import java.util.*;

public class lcsubString {

    public static int solve(String s1, String s2, int m, int n, int count) {
        // Base case: if either string is empty
        if (m == 0 || n == 0) {
            return count;
        }

        // If the characters match, extend the current substring
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            count = solve(s1, s2, m - 1, n - 1, count + 1);
        }

        // Otherwise, reset the count and explore other possibilities
        return Math.max(count, Math.max(
                solve(s1, s2, m - 1, n, 0),
                solve(s1, s2, m, n - 1, 0)));
    }

    public static int solve(String str1, String str2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1 = "abcdgh";
        String str2 = "acdghr";

        int n = str1.length();
        int m = str2.length();
        int count = 0;
        // int ans = solve(str1, str2, n, m, count);
        // System.out.println("Result: " + ans);

        ////////////////// Tabulation //////////////

        int ans = solve(str1, str2, n, m);
        System.out.println("result: " + ans);
    }
}
