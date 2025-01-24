import java.util.*;

public class lcs {

    /////////////////////////////// Recursion ////////////////////////////////

    // public static int solve(String x, String y, int n, int m) {
    // // base Case
    // if (n == 0 || m == 0) {
    // return 0;
    // }

    // if (x.charAt(n - 1) == y.charAt(m - 1)) {
    // return 1 + solve(x, y, n - 1, m - 1);
    // } else {
    // return Math.max(solve(x, y, n - 1, m), solve(x, y, n, m - 1));
    // }
    // }

    //////////////////////////////// Memoization /////////////////////////////
    public static int solve(String x, String y, int dp[][], int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        /// if calculated Earlier
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            return dp[n][m] = 1 + solve(x, y, dp, n - 1, m - 1);

        } else {
            return dp[n][m] = Math.max(solve(x, y, dp, n - 1, m), solve(x, y, dp, n, m - 1));
        }
    }

    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "abcdh";
        int n = x.length();
        int m = y.length();

        ///////////////////// Rescusion ////////////////
        // int ans = solve(x, y, n, m);
        // System.out.println("Result: " + ans);

        //////////////////// Memoization ///////////////
        int dp[][] = new int[n + 1][m + 1];

        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }

        int ans = solve(x, y, dp, n, m);
        System.out.println("Result: " + ans);
    }
}
