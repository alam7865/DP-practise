import java.util.*;

public class lcsRec {
    // public static int lcs(String str1, String str2, int n, int m, int dp[][]) {
    // // Base Case
    // if (n == 0 || m == 0) {
    // return 0;
    // }

    // if (dp[n - 1][m - 1] != -1) {
    // return dp[n - 1][m - 1];
    // }
    // if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
    // return 1 + lcs(str1, str2, n - 1, m - 1, dp);
    // } else {
    // return Math.max(lcs(str1, str2, n - 1, m, dp), lcs(str1, str2, n, m - 1,
    // dp));
    // }
    // }

    /////////////////////// Tabulation ///////////////////////////

    public static int lcs(
            String str1, String str2,
            int n,
            int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "bbabcbcab";
        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.reverse();
        String str2 = sb.toString();
        int n = str1.length();
        int m = str2.length();

        // int dp[][] = new int[n + 1][m + 1];

        // for (int[] i : dp) {
        // Arrays.fill(i, -1);
        // }
        // // System.out.println(sb.toString());
        // int res = lcs(str1, str2, n, m, dp);
        // System.out.println("Result: " + res);

        /////////////////// Tabulation ///////////////////

        int res = lcs(str1, str2, n, m);
        System.out.println("Result: " + res);
    }
}
