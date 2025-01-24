import java.util.*;

public class rodcutting {
    // public static int solve(int wt[], int price[], int w, int n) {
    // if (n == 0 || w == 0) {
    // return 0;
    // }

    // if (wt[n - 1] <= w) {
    // // Include
    // int ans1 = price[n - 1] + solve(wt, price, w - wt[n - 1], n);
    // // Exclude
    // int ans2 = solve(wt, price, w, n - 1);

    // return Math.max(ans1, ans2);
    // } else {
    // return solve(wt, price, w, n - 1);
    // }
    // }

    ////////////////////////////////////////////////////////
    public static int solve(int wt[], int price[], int w, int n, int dp[][]) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (dp[n][w] != -1) {
            return dp[n][w];
        }

        if (wt[n - 1] <= w) {
            // Include
            int ans1 = price[n - 1] + solve(wt, price, w - wt[n - 1], n, dp);
            // Exclude
            int ans2 = solve(wt, price, w, n - 1, dp);

            int res = Math.max(ans1, ans2);
            return dp[n][w] = res;
        } else {
            dp[n][w] = solve(wt, price, w, n - 1, dp);
        }

        return dp[n][w];
    }

    public static int solveTabulation(int wt[], int price[], int w) {
        int n = wt.length;
        // Initialize the DP table (n+1)x(w+1) with all zeros
        int[][] dp = new int[n + 1][w + 1];

        // Build the table bottom-up
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                // If the current rod length can be used (i.e., wt[i-1] <= j)
                if (wt[i - 1] <= j) {
                    // Include the current length or exclude it
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    // Exclude the current length (as it exceeds current weight)
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // The maximum revenue is stored in dp[n][w]
        return dp[n][w];
    }

    public static int sloveTab(int wt[], int price[], int w) {
        int dp[][] = new int[wt.length + 1][w + 1];

        for (int i = 1; i <= wt.length; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    // Include
                    int ans1 = price[i - 1] + dp[i][j - wt[i - 1]];
                    // Exclude
                    int ans2 = dp[i - 1][j];

                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[wt.length][w];
    }

    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17 };
        int w = 5;
        int wt[] = { 1, 2, 3, 4, 5, 6 };

        int dp[][] = new int[wt.length + 1][w + 1];

        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        // int ans = solve(wt, price, w, price.length);
        // System.out.println("Result: " + ans);

        /////////////////////////////////////
        // int ans = solve(wt, price, w, price.length, dp);
        // System.out.println("Result: " + ans);

        // int ans = solveTabulation(wt, price, w);
        // System.out.println("Result (Tabulation): " + ans);

        int ans = sloveTab(wt, price, w);
        System.out.println("Result: " + ans);
    }
}
