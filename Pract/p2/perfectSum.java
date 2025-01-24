import java.util.*;

public class perfectSum {
    public static int solve(int arr[], int n, int target) {
        // if (target == 0) {
        // return 1;
        // }

        // if (n == 0) {
        // return 0;
        // }

        // if (arr[n - 1] <= target) {
        // return solve(arr, n - 1, target - arr[n - 1]) + solve(arr, n - 1, target);
        // } else {
        // return solve(arr, n - 1, target);
        // }

        int dp[][] = new int[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
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
        int arr[] = { 28, 4, 3, 27, 0, 24, 26 };
        int target = 24;

        int ans = solve(arr, arr.length, target);
        System.out.println("Result: " + ans);
    }
}
