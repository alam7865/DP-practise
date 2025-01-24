import java.util.*;

public class targetSum {

    // public static boolean solve(int arr[], int target, int n) {
    // if (target == 0) {
    // return true;
    // }

    // if (n == 0) {
    // return false;
    // }

    // if (arr[n - 1] <= target) {
    // // include
    // boolean include = solve(arr, target - arr[n - 1], n - 1);
    // // exclude
    // boolean exclude = solve(arr, target, n - 1);

    // return include || exclude;
    // } else {
    // return solve(arr, target, n - 1);
    // }
    // }

    ////////////////////////////////// memoization ///////////////////////

    // public static boolean solve(int arr[], int target, int n, boolean mat[][]) {
    // if (target == 0) {
    // return true;
    // }

    // if (n == 0) {
    // return false;
    // }

    // if (mat[n][target] != false) {
    // return mat[n][target];
    // }
    // if (arr[n - 1] <= target) {
    // // include
    // boolean include = solve(arr, target - arr[n - 1], n - 1, mat);
    // // exclude
    // boolean exclude = solve(arr, target, n - 1, mat);

    // return mat[n][target] = include || exclude;
    // } else {
    // return mat[n][target] = solve(arr, target, n - 1, mat);
    // }
    // }

    ///////////////////////////////// Tabulation //////////////////////
    public static boolean solve(int arr[], int target, int n) {
        boolean dp[][] = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
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

        // boolean ans = solve(arr, target, arr.length);
        // System.out.println("Result: " + ans);

        ////////////////////// memoization //////////////////////////
        // boolean mat[][] = new boolean[arr.length + 1][target + 1];

        // for (boolean[] i : mat) {
        // System.out.println(Arrays.toString(i));
        // }

        // boolean ans = solve(arr, target, arr.length, mat);
        // System.out.println("Result: " + ans);

        /////////////////////////// Tabulation /////////////////////////////
        boolean ans = solve(arr, target, arr.length);
        System.out.println("Result: " + ans);
    }
}
