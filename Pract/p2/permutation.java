import java.util.*;

public class permutation {
    public static int solve(String str1, String str2, int n, int m, int mat[][]) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (mat[n - 1][m - 1] != -1) {
            return mat[n - 1][m - 1];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return mat[n][m] = 1 + solve(str1, str2, n - 1, m - 1, mat);
        } else {
            return mat[n][m] = Math.max(solve(str1, str2, n, m - 1, mat), solve(str1, str2, n - 1, m, mat));
        }
    }

    public static void main(String[] args) {
        String str1 = "abcdgh";
        String str2 = "adefhr";
        int n = str1.length();
        int m = str2.length();
        int mat[][] = new int[n + 1][m + 1];
        for (int i[] : mat) {
            Arrays.fill(i, -1);
        }

        int ans = solve(str1, str2, n, m, mat);
        System.out.println(ans);
    }
}
