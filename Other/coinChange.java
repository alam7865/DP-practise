import java.util.*;

public class coinChange {

    // public static int solve(int coin[], int n, int sum) {
    // if (sum == 0) {
    // return 1;
    // }

    // if (n == 0) {
    // return 0;
    // }

    // if (coin[n - 1] <= sum) {
    // // Include
    // int ans1 = solve(coin, n, sum - coin[n - 1]);
    // // Exclude
    // int ans2 = solve(coin, n - 1, sum);
    // return ans1 + ans2;
    // } else {
    // int ans2 = solve(coin, n - 1, sum);
    // return ans2;
    // }
    // }

    public static int solve(int coin[], int n, int sum, int dp[][]) {
        if (sum == 0) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }

        if (coin[n - 1] <= sum) {
            // Include
            int ans1 = solve(coin, n, sum - coin[n - 1], dp);
            // Exclude
            int ans2 = solve(coin, n - 1, sum, dp);

            return dp[n][sum] = ans1 + ans2;
        } else {
            return dp[n][sum] = solve(coin, n - 1, sum, dp);
        }
    }

    public static void main(String[] args) {
        int coin[] = { 1, 2, 3 };
        int n = 3;
        int sum = 4;

        // int ans = solve(coin, n, sum);
        // System.out.println("result: " + ans);

        ////////////// memoization ////////////////////

        int dp[][] = new int[n + 1][sum + 1];

        for (int[] i1 : dp) {
            Arrays.fill(i1, -1);
        }
        int ans = solve(coin, n, sum, dp);
        System.out.println("Result: " + ans);
    }
}
