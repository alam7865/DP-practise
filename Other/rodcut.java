import java.util.*;

public class rodcut {

    // public static int solve(int price[], int length[], int n, int w) {
    // if (n == 0 || w == 0) {
    // return 0;
    // }

    // if (length[n - 1] <= w) {
    // // Include
    // int ans1 = price[n - 1] + solve(price, length, n, w - length[n - 1]);
    // // Exclude
    // int ans2 = solve(price, length, n - 1, w);

    // return Math.max(ans1, ans2);
    // } else {
    // return solve(price, length, n - 1, w);
    // }

    // }

    ////////// Memoization /////////////////////

    // public static int solve(int price[], int length[], int n, int w, int dp[][])
    // {
    // if (n == 0 || w == 0) {
    // return 0;
    // }

    // if (dp[n][w] != -1) {
    // return dp[n][w];
    // }

    // if (length[n - 1] <= w) {
    // // Include
    // int ans1 = price[n - 1] + solve(price, length, n, w - length[n - 1], dp);
    // // Exclude
    // int ans2 = solve(price, length, n - 1, w, dp);

    // int ans = Math.max(ans1, ans2);
    // return dp[n][w] = ans;
    // } else {
    // return dp[n][w] = solve(price, length, n - 1, w, dp);
    // }
    // }

    /////////////////// Tabulation //////////////////////////////////
    public static int solve(int price[], int length[], int n, int w) {
        int dp[][] = new int[n + 1][w + 1];

        // for (int i = 1; i < n + 1; i++) {
        // dp[i][0] = 1;
        // }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (length[i - 1] <= j) {
                    // Include
                    int ans1 = price[i - 1] + dp[i][j - length[i - 1]];
                    // Exclude
                    int ans2 = dp[i - 1][j];

                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    int ans2 = dp[i - 1][j];
                    dp[i][j] = ans2;
                }
            }
        }

        return dp[n][w];
    }

    public static void main(String args[]) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };

        int n = price.length;
        int w = 8;

        // int ans = solve(price, length, n, w);

        // System.out.println("Result: " + ans);

        /////////////// memoization //////////////////////
        // int dp[][] = new int[n + 1][w + 1];

        // for (int[] i : dp) {
        // Arrays.fill(i, -1);
        // }

        // int ans = solve(price, length, n, w, dp);
        // System.out.println("Result: " + ans);

        ///////////////// Tabulation //////////////////////

        int ans = solve(price, length, n, w);
        System.out.println("Tabulation Res: " + ans);
    }
}
