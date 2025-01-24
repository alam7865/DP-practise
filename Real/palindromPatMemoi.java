import java.util.*;

public class palindromPatMemoi {

    public static boolean isPalindrom(String str, int i, int j) {
        if (i >= j) {
            return true;
        }

        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            // else {
            i++;
            j--;
            // }
        }

        return true;
    }

    public static int solve(String str, int i, int j, int dp[][]) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrom(str, i, j) == true) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int left;

            if (dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = dp[i][k] = solve(str, i, k, dp);
            }

            //
            int right;

            if (dp[k + 1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                right = dp[k + 1][j] = solve(str, k + 1, j, dp);
            }
            int temp = left + right + 1;
            ans = Math.min(ans, temp);
        }

        return dp[i][j] = ans;
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        int n = str.length();
        int i = 0;
        int j = str.length() - 1;

        int dp[][] = new int[n + 1][n + 1];

        for (int[] i1 : dp) {
            Arrays.fill(i1, -1);
        }
        int ans = solve(str, i, j, dp);
        System.out.println("Result: " + ans);
    }
}
