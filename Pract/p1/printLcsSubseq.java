import java.util.*;

public class printLcsSubseq {

    // public static String solve(String str1, String str2, int n, int m) {
    // if (n == 0 || m == 0) {
    // return "";
    // }

    // if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
    // return solve(str1, str2, n - 1, m - 1) + str1.charAt(n - 1);
    // } else {
    // String ans1 = solve(str1, str2, n, m - 1);
    // String ans2 = solve(str1, str2, n - 1, m);

    // if (ans1.length() > ans2.length()) {
    // return ans1;
    // } else {
    // return ans2;
    // }
    // }
    // }

    //////////////////// memoization //////////////////////////////
    // public static String solve(String str1, String str2, int n, int m, String
    //////////////////// dp[][]) {
    // if (n == 0 || m == 0) {
    // return "";
    // }

    // if (dp[n][m] != null) {
    // return dp[n][m];
    // }

    // if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
    // return dp[n][m] = solve(str1, str2, n - 1, m - 1, dp) + str1.charAt(n - 1);
    // } else {
    // String ans1 = solve(str1, str2, n, m - 1, dp);
    // String ans2 = solve(str1, str2, n - 1, m, dp);

    // if (ans1.length() > ans2.length()) {
    // return dp[n][m] = ans1;
    // } else {
    // return dp[n][m] = ans2;
    // }
    // }
    // }

    ///////////////////////////// Tabulation /////////////////////////////////
    // public static String solve(String str1, String str2, int n, int m) {
    // String dp[][] = new String[n + 1][m + 1];
    // for (String[] i1 : dp) {
    // Arrays.fill(i1, "");
    // }
    // for (int i = 1; i < n + 1; i++) {
    // for (int j = 1; j < m + 1; j++) {
    // if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
    // dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);

    // } else {
    // if (dp[i - 1][j].length() > dp[i][j - 1].length()) {
    // dp[i][j] = dp[i - 1][j];
    // } else {
    // dp[i][j] = dp[i][j - 1];
    // }
    // }
    // }
    // }

    // // System.out.println(dp[n][m]);
    // for (String[] st : dp) {
    // System.out.println(Arrays.toString(st));
    // }
    // return "aaaaaa";
    // }

    /////////////////// tabulation int ///////////////////////
    public static String solve(String str1, String str2, int n, int m) {
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

        int i = n;
        int j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        sb.reverse();
        System.out.println(sb.toString());
        return "aaa";
    }

    public static void main(String[] args) {
        // String str1 = "abc";
        // String str2 = "gbcf";

        String str1 = "aggtab";
        String str2 = "gxtxayb";
        int n = str1.length();
        int m = str2.length();
        // String ans = solve(str1, str2, n, m);
        // System.out.println("Result: " + ans);

        ///////////////// Memoization ///////////////////////
        // String dp[][] = new String[n + 1][m + 1];
        // String ans = solve(str1, str2, n, m, dp);
        // System.out.println("Result: " + ans);

        // ///////////// Tabulation ///////////////////////////
        String ans = solve(str1, str2, n, m);
        System.out.println("Result: " + ans);

    }
}
