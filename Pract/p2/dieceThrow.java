import java.util.*;

public class dieceThrow {
    public static int solve(int m, int n, int x, int sum, int dp[][]) {
        // base case
        if (n == 0) {
            if (sum == x) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        int ways = 0;
        for (int i = 1; i <= m; i++) {
            if (sum + i <= x) {
                ways += solve(m, n - 1, x, sum + i, dp);
            }
        }

        dp[n][sum] = ways;
        return ways;
    }

    public static void main(String[] args) {
        int m = 6;
        int n = 3;
        int x = 12;
        int dp[][] = new int[n + 1][x + 1];

        for (int i[] : dp) {
            Arrays.fill(i, -1);
        }
        int ans = solve(m, n, x, 0, dp);
        System.out.println("Result: " + ans);
    }
}
