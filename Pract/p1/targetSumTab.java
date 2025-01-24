import java.util.*;

public class targetSumTab {
    public static void main(String[] args) {
        int num[] = { 4, 2, 7, 1, 3 };
        int tar = 10;
        int n = num.length;

        boolean dp[][] = new boolean[n + 1][tar + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < tar + 1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < tar + 1; j++) {
                // Include
                if (num[i - 1] <= j) {
                    // Include
                    boolean ans1 = dp[i - 1][j - num[i - 1]];
                    // Exclude
                    boolean ans2 = dp[i - 1][j];
                    if (ans1 == true || ans2 == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // System.out.println(dp[n][tar]);

        for (boolean[] i : dp) {
            System.out.println(Arrays.toString(i));
        }

    }
}
