import java.util.*;

public class sequentialPattMatch {
    public static int solve(String str1, String str2, int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return solve(str1, str2, n - 1, m - 1) + 1;
        } else {
            return Math.max(solve(str1, str2, n - 1, m), solve(str1, str2, n, m - 1));
        }
    }

    public static void main(String[] args) {
        String str1 = "axx";
        String str2 = "adxcpy";
        int n = str1.length();
        int m = str2.length();
        int ans = solve(str1, str2, n, m);

        if (ans == n) {
            System.out.println("True1");
        } else {
            System.out.println("False1");
        }
    }
}
