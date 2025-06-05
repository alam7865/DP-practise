import java.util.*;

public class lcs2 {
    public static int lcs(String a, String b, int n, int m) {
        // if (n == 0 || m == 0) {
        // return 0;
        // }

        // if (a.charAt(n - 1) == b.charAt(m - 1)) {
        // return 1 + lcs(a, b, n - 1, m - 1);
        // } else {
        // return Math.max(lcs(a, b, n - 1, m), lcs(a, b, n, m - 1));
        // }

        int s1 = n;
        int s2 = m;
        int mat[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    mat[i][j] = 1 + mat[i - 1][j - 1];
                } else {
                    mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]);
                }
            }
        }

        for (int[] k : mat) {
            System.out.println(Arrays.toString(k));
        }

        StringBuilder sb = new StringBuilder();

        while (s1 > 0 && s2 > 0) {
            if (a.charAt(s1 - 1) == b.charAt(s2 - 1)) {
                sb.append(a.charAt(s1 - 1));
                s1--;
                s2--;
            } else {
                if (mat[s1][s2 - 1] > mat[s1 - 1][s2]) {
                    s2--;
                } else {
                    s1--;
                }
            }
        }
        sb.reverse();
        System.out.println(sb.toString());
        return 6;
    }

    public static void main(String args[]) {
        String a = "acbcf";
        String b = "abcdaf";

        int ans = lcs(a, b, a.length(), b.length());
        System.out.println("Result: " + ans);
    }
}
