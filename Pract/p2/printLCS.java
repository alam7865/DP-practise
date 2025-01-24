import java.util.*;

public class printLCS {

    public static int solve(String str1, String str2, int n, int m) {
        int dp[][] = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }

        int i = n;
        int j = m;
        StringBuilder sb = new StringBuilder();

        while (i >= 1 && j >= 1) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            } else {
                i--;
            }
        }

        sb.reverse();
        System.out.println(sb.toString());

        return 5;
    }

    public static void main(String[] args) {
        String str1 = "acbcf";
        String str2 = "abcdaf";

        int n = str1.length();
        int m = str2.length();

        int ans = solve(str1, str2, n, m);
        System.out.println("Result: " + ans);
    }
}
