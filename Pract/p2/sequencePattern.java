import java.util.*;

public class sequencePattern {

    public static int solve(String str1, String str2, int n, int m) {
        // if (n == 0 || m == 0) {
        // return 0;
        // }

        // if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
        // return 1 + solve(str1, str2, n - 1, m - 1);
        // }

        // return Math.max(solve(str1, str2, n - 1, m), solve(str1, str2, n, m - 1));

        /////////////////////////// above using DP /////////////////////////////

        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
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
        String str1 = "coaching";
        String str2 = "coding";
        int n = str1.length();
        int m = str2.length();

        int ans = solve(str1, str2, n, m);
        // if (ans == n) {
        // System.out.println("True");
        // }
        System.out.println("Result: " + ans);
    }
}
