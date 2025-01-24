import java.util.*;

public class unBundedKnap {

    // public static int solve(int val[], int wt[], int capacity, int n) {
    // // base case
    // if (capacity == 0 || n == 0) {
    // return 0;
    // }

    // if (wt[n - 1] <= capacity) {
    // // include
    // int include = val[n - 1] + solve(val, wt, capacity - wt[n - 1], n);

    // // exclude
    // int exclude = solve(val, wt, capacity, n - 1);

    // return Math.max(include, exclude);
    // } else {
    // return solve(val, wt, capacity, n - 1);
    // }
    // }

    ////////////////////////////// memoization ////////////////////////
    // public static int solve(int val[], int wt[], int capacity, int n, int dp[][])
    ////////////////////////////// {
    // if (n == 0 || capacity == 0) {
    // return 0;
    // }

    // if (dp[n][capacity] != -1) {
    // return dp[n][capacity];
    // }

    // if (wt[n - 1] <= capacity) {
    // // include
    // int include = val[n - 1] + solve(val, wt, capacity - wt[n - 1], n, dp);
    // // exclude
    // int exclude = solve(val, wt, capacity, n - 1, dp);

    // return dp[n][capacity] = Math.max(include, exclude);
    // } else {
    // return dp[n][capacity] = solve(val, wt, capacity, n - 1, dp);
    // }
    // }

    /////////////////////////////// Tabulation //////////////////////////////

    public static int solve(int val[], int wt[], int capacity, int n) {
        int dp[][] = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                int val1 = val[i - 1];
                int wt1 = wt[i - 1];

                if (wt1 <= j) {
                    // include
                    int include = val1 + dp[i][j - wt1];
                    // exclude
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int capacity = 4;
        int val[] = { 1, 2, 3 };
        int wt[] = { 4, 5, 1 };
        int n = val.length;

        // int ans = solve(val, wt, capacity, n);
        // System.out.println("Result: " + ans);

        ///////////////////// memoization ///////////////////////

        // int dp[][] = new int[n + 1][capacity + 1];

        // for (int[] i : dp) {
        // Arrays.fill(i, -1);
        // }

        // int ans = solve(val, wt, capacity, n, dp);
        // System.out.println("Result: " + ans);

        /////////////////////////////// Tabulation //////////////////////////////
        int ans = solve(val, wt, capacity, n);
        System.out.println("Result: " + ans);
    }
}
