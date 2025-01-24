import java.util.*;

public class subset {

    public static boolean solve(int arr[], int sum, int n) {
        if (sum == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        if (arr[n - 1] <= sum) {
            // Include
            boolean ans1 = solve(arr, sum - arr[n - 1], n - 1);
            // Exclude
            boolean ans2 = solve(arr, sum, n - 1);
            return ans1 || ans2;
        } else {
            boolean ans2 = solve(arr, sum, n - 1);
            return ans2;
        }
    }

    public static boolean solve(int arr[], int sum, int n, boolean dp[][]) {
        if (sum == 0) {
            return true;
        }

        if (n == 0) {
            return false;
        }

        if (dp[n][sum] != false) {
            return true;
        }

        if (arr[n - 1] <= sum) {
            // Include
            boolean ans1 = solve(arr, sum - arr[n - 1], n - 1);
            // Exclude
            boolean ans2 = solve(arr, sum, n - 1);

            dp[n][sum] = ans1 || ans2;
            return dp[n][sum];
        } else {
            boolean ans2 = solve(arr, sum, n - 1);
            dp[n][sum] = ans2;
            return dp[n][sum];
        }

    }

    public static void main(String args[]) {
        int arr[] = { 1, 1, 2, 2, 3, 4, 5, 5, 6, 7 };
        int sum = 1;
        int n = arr.length;

        // boolean ans = solve(arr, sum, n);
        // System.out.println("Result: " + ans);

        boolean dp[][] = new boolean[n + 1][sum + 1];
        boolean ans = solve(arr, sum, n, dp);
        System.out.println("result1: " + ans);
    }
}
