import java.util.*;

public class lcsStr3 {

    public static int solve(String a, String b, String c, int n, int m, int l, int mat[][][]) {
        if (n == 0 || m == 0 || l == 0) {
            return 0;
        }

        if (mat[n][m][l] != -1) {
            return mat[n][m][l];
        }
        if ((a.charAt(n - 1) == b.charAt(m - 1)) && (a.charAt(n - 1) == c.charAt(l - 1))) {
            return mat[n][m][l] = 1 + solve(a, b, c, n - 1, m - 1, l - 1, mat);
        } else {
            return mat[n][m][l] = Math.max(Math.max(solve(a, b, c, n - 1, m, l, mat), solve(a, b, c, n, m - 1, l, mat)),
                    solve(a, b, c, n, m, l - 1, mat));
        }
    }

    public static void main(String args[]) {
        String a = "geeks";
        String b = "geeksfor";
        String c = "geeksforgeeks";

        int n = a.length();
        int m = b.length();
        int l = c.length();

        int mat[][][] = new int[n + 1][m + 1][l + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(mat[i][j], -1); // mat[i][j] is a 1D array
            }
        }

        int ans = solve(a, b, c, n, m, l, mat);
        System.out.println("Result: " + ans);

    }
}
