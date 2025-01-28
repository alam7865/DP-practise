import java.util.*;

public class longestRepeatingSub {
    // public static int solve(String str1, String str2, int n, int m) {
    // if (n == 0 || m == 0) {
    // return 0;
    // }

    // if (str1.charAt(n - 1) == str2.charAt(m - 1) && (m != n)) {
    // return 1 + solve(str1, str2, n - 1, m - 1);
    // }
    // return Math.max(solve(str1, str2, n - 1, m), solve(str1, str2, n, m - 1));

    // }

    public static int helper(String str1, String str2, int m, int n) {
        // Base condition: if either string is exhausted
        if (m == 0 || n == 0) {
            return 0;
        }

        // If characters match and their indices are different
        if (str1.charAt(m - 1) == str2.charAt(n - 1) && m != n) {
            return 1 + helper(str1, str2, m - 1, n - 1);
        }

        // If characters don't match, explore both possibilities
        return Math.max(helper(str1, str2, m - 1, n), helper(str1, str2, m, n - 1));
    }

    public static void main(String[] args) {
        String str1 = "AABCBCDD";
        String str2 = "AABCBCDD";
        int n = str1.length();
        int m = str2.length();

        int ans = helper(str1, str2, m, n);
        System.out.println("Result: " + ans);

    }
}
