import java.util.*;

public class palindromParitition {

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

    public static int solve(String str, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrom(str, i, j) == true) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;

        for (int k = i; k <= j - 1; k++) {
            int temp = solve(str, i, k) + solve(str, k + 1, j) + 1;
            ans = Math.min(ans, temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "ababbbabbababa";

        int i = 0;
        int j = str.length() - 1;

        int ans = solve(str, i, j);
        System.out.println("Result: " + ans);
    }
}
