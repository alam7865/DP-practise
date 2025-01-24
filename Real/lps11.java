import java.util.*;

public class lps11 {
    // public static int solve(String str1, String str2, int n, int m) {

    // ///////////////////// Recursive ///////////////////////////

    // // if (n == 0 || m == 0) {
    // // return 0;
    // // }

    // // if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
    // // return solve(str1, str2, n - 1, m - 1) + 1;
    // // } else {
    // // return Math.max(solve(str1, str2, n - 1, m), solve(str1, str2, n, m - 1));
    // // }
    // }

    /////////////////////////// memoization ////////////////////////////

    // public static int solve(String str1, String str2, int n, int m, int dp[][]) {
    // if (n == 0 || m == 0) {
    // return 0;
    // }

    // if (dp[n][m] != -1) {
    // return dp[n][m];
    // }

    // if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
    // return dp[n][m] = solve(str1, str2, n - 1, m - 1, dp) + 1;
    // } else {
    // return dp[n][m] = Math.max(solve(str1, str2, n - 1, m, dp), solve(str1, str2,
    // n, m - 1, dp));
    // }
    // }

    /////////////////////////// Tabulation ////////////////////////////////

    public static int solve(String str1, String str2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {
        String str1 = "agbcba";
        String str2 = "abcbga";

        int n = str1.length();
        int m = str2.length();

        // int ans = solve(str1, str2, n, m);
        // System.out.println("result: " + ans);

        ///////////// memoization //////////////////
        // int dp[][] = new int[n + 1][m + 1];
        // for (int[] i1 : dp) {
        // Arrays.fill(i1, -1);
        // }

        // int ans = solve(str1, str2, n, m, dp);
        // System.out.println("Result: " + ans);

        ////////////// Tabulation /////////////////
        int ans = solve(str1, str2, n, m);
        System.out.println("Result: " + ans);
    }
}
