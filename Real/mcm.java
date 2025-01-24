import java.util.*;

public class mcm {

    // public static int solve(int arr[], int i, int j) {
    // if (i >= j) {
    // return 0;
    // }

    // int ans = Integer.MAX_VALUE;
    // for (int k = i; k <= j - 1; k++) {
    // int temp = solve(arr, i, k) + solve(arr, k + 1, j) + arr[i - 1] * arr[j] *
    // arr[k];
    // ans = Math.min(ans, temp);
    // }

    // return ans;
    // }

    //////////////////////////////// memoization /////////////////////

    public static int solve(int arr[], int i, int j, int dp[][]) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(arr, i, k, dp) + solve(arr, k + 1, j, dp) + arr[i - 1] * arr[k] * arr[j];
            ans = Math.min(ans, temp);
        }

        return dp[i][j] = ans;
    }

    public static void main(String args[]) {
        int arr[] = { 10, 30, 5, 60 };
        int n = arr.length;

        int i = 1;
        int j = n - 1;

        // int ans = solve(arr, i, j);
        // System.out.println("Result: " + ans);

        // /////////////////// Memoization /////////////////////
        int dp[][] = new int[n + 1][n + 1];

        for (int[] i1 : dp) {
            Arrays.fill(i1, -1);
        }

        int ans = solve(arr, i, j, dp);
        System.out.println("Result: " + ans);
    }
}
