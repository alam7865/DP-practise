import java.util.*;

public class longRepeatSubseq {
    // public static int solve(String str, int n, int m) {
    // if (n == 0 || m == 0) {
    // return 0;
    // }

    // if (str.charAt(n - 1) == str.charAt(m - 1) && n != m) {
    // return solve(str, n - 1, m - 1) + 1;
    // } else {
    // return Math.max(solve(str, n - 1, m), solve(str, n, m - 1));
    // }
    // }

    ///////////////////////////// Memoization ///////////////////

    // public static int solve(String str, int n, int m, int dp[][]) {
    // if (n == 0 || m == 0) {
    // return 0;
    // }

    // if (str.charAt(n - 1) == str.charAt(m - 1) && n != m) {
    // return dp[n][m] = solve(str, n - 1, m - 1, dp) + 1;
    // } else {
    // return dp[n][m] = Math.max(solve(str, n - 1, m, dp), solve(str, n, m - 1,
    // dp));
    // }
    // }

    ////////////////////////// Tabulation ///////////////////////

    public static int solve(String str, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str = "AABCBC";
        int n = str.length();

        // int ans = solve(str, n, n);
        // System.out.println("Result: " + ans);

        /////////////////////// Memoization ////////////////////
        // int dp[][] = new int[n + 1][n + 1];

        // for (int[] i1 : dp) {
        // Arrays.fill(i1, -1);
        // }

        // int ans = solve(str, n, n, dp);
        // System.out.println("Result: " + ans);

        /////////////////////// Tabulation //////////////////////
        int ans = solve(str, n, n);
        System.out.println("Result: " + ans);
    }
}
