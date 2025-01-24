import java.util.*;

public class countTargetSum {
    // public static int count = 0;

    // public static int solve(int arr[], int target, int n) {
    // if (target == 0) {
    // return 1;
    // // return true;
    // }

    // if (n == 0) {
    // return 0;
    // }

    // if (arr[n - 1] <= target) {
    // return solve(arr, target - arr[n - 1], n - 1) + solve(arr, target, n - 1);
    // } else {
    // return solve(arr, target, n - 1);
    // }

    // }

    /////////////////////////////////// Memoization ////////////////////////////
    // public static int solve(int arr[], int target, int n, int dp[][]) {
    // if (target == 0) {
    // return 1;
    // }

    // if (n == 0) {
    // return 0;
    // }

    // if (dp[n][target] != -1) {
    // return dp[n][target];
    // }

    // if (arr[n - 1] <= target) {
    // return dp[n][target] = solve(arr, target - arr[n - 1], n - 1, dp) +
    // solve(arr, target, n - 1, dp);
    // } else {
    // return dp[n][target] = solve(arr, target, n - 1, dp);
    // }
    // }

    ///////////////////////////////// Tabulation /////////////////////////
    public static int solve(int arr[], int target, int n) {
        int dp[][] = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= target; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 7, 2 };
        int target = 5;
        int n = arr.length;
        // int count = 0;
        // int ans = solve(arr, target, arr.length);

        // System.out.println("Result: " + ans);

        ////////////////////// Memoization ////////////////////////

        // int dp[][] = new int[n + 1][target + 1];

        // for (int[] i : dp) {
        // Arrays.fill(i, -1);
        // // System.out.println(Arrays.toString(i));
        // }

        // int ans = solve(arr, target, n, dp);
        // System.out.println("result: " + ans);

        ///////////////////// Tabulation /////////////////////////
        int ans = solve(arr, target, arr.length);

        System.out.println("Result: " + ans);
    }
}
