import java.util.*;

public class shortCommSuper {

    // public static int solve(String str1, String str2, int n, int m) {
    // if (n == 0 || m == 0) {
    // return 0;
    // }

    // if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
    // return solve(str1, str2, n - 1, m - 1) + 1;
    // } else {
    // return Math.max(solve(str1, str2, n - 1, m), solve(str1, str2, n, m - 1));
    // }
    // }

    /////////////////////////////////// tabulation
    /////////////////////////////////// ///////////////////////////////////

    // public static int dp[][] = new int[5 + 1][6 + 1];
    public static int dp[][] = new int[3 + 1][4 + 1];

    public static int solve(String str1, String str2, int n, int m) {

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // for (int[] i1 : dp) {
        // System.out.println(Arrays.toString(i1));
        // }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str2 = "geek";
        String str1 = "eke";

        // String str1 = "acbcf";
        // String str2 = "abcdaf";
        int n = str1.length();
        int m = str2.length();
        int len = n + m;
        // int ans = solve(str1, str2, n, m);
        // System.out.println("result: " + ans);
        // System.out.println("LCS: " + (len - ans));

        // //////////////////////////// Tabulation ///////////////////////////////////

        int ans = solve(str1, str2, n, m);
        for (int[] i1 : dp) {
            System.out.println(Arrays.toString(i1));
        }
        String res = "";
        while (n > 0 || m > 0) {
            if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
                res += str1.charAt(n - 1);
                n--;
                m--;
            } else {
                if (dp[n - 1][m] > dp[n][m - 1]) {
                    res += str1.charAt(n - 1);
                    n--;
                } else if (dp[n][m - 1] > dp[n - 1][m]) {
                    res += str2.charAt(m - 1);
                    m--;
                }
            }
        }

        while (n > 0) {
            res += str1.charAt(n - 1);
            n--;
        }

        while (m > 0) {
            res += str1.charAt(m - 1);
            m--;
        }
        System.out.println("Resultssss: " + res);
    }
}
