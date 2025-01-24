import java.util.*;

public class unBonKnap {

    // public static int solve(int val[], int wt[], int w, int n) {
    // if (n == 0 || w == 0) {
    // return 0;
    // }

    // //
    // if (wt[n - 1] <= w) {
    // // Include
    // int ans1 = val[n - 1] + solve(val, wt, w - wt[n - 1], n);
    // // Exclude
    // int ans2 = solve(val, wt, w, n - 1);

    // return Math.max(ans1, ans2);
    // } else {
    // return solve(val, wt, w, n - 1);
    // }

    // }

    //////////////////////////////////////////////
    // public static int dp[][];

    public static int solve(int val[], int wt[], int w, int n, int dp[][]) {
        if (n == 0 || w == 0) {
            return 0;
        }

        //

        if (dp[n][w] != -1) {
            return dp[n][w];
        }
        if (wt[n - 1] <= w) {
            // Include
            int ans1 = val[n - 1] + solve(val, wt, w - wt[n - 1], n, dp);
            // Exclude
            int ans2 = solve(val, wt, w, n - 1, dp);
            dp[n][w] = Math.max(ans1, ans2);
            // return dp[n][w];
        } else {
            dp[n][w] = solve(val, wt, w, n - 1, dp);
            // return dp[n][w];
        }

        return dp[n][w];
    }

    public static void main(String[] args) {
        // int val[] = { 15, 14, 10, 45, 30 };
        // int wt[] = { 2, 5, 1, 3, 4 };

        // int w = 7;
        // int n = val.length;
        // int dp[][] = new int[n + 1][w + 1];

        // for (int[] i : dp) {
        // Arrays.fill(i, -1);
        // }
        // int ans = solve(val, wt, w, n, dp);
        // System.out.println("Result: " + ans);
        // System.out.println("DP: " + dp[n][w]);

        int cc = 1 + 97;
        char ch = (char) cc;
        System.out.println(ch);
    }
}
