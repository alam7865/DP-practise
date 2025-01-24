import java.util.*;

public class rodCutting {

    // public static int solve(int price[], int n, int wt[], int target) {
    // if (n == 0 || target == 0) {
    // return 0;
    // }

    // if (wt[n - 1] <= target) {
    // int ans1 = price[n - 1] + solve(price, n, wt, target - wt[n - 1]);
    // // exclude
    // int ans2 = solve(price, n - 1, wt, target);

    // return Math.max(ans1, ans2);
    // } else {
    // return solve(price, n - 1, wt, target);
    // }
    // }

    //////////////////////////////////////////////////////////////////////////////////////////////
    public static int solve(int price[], int n, int wt[], int target) {
        int dp[][] = new int[n + 1][target + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (wt[i - 1] <= j) {
                    int ans1 = price[i - 1] + dp[i][j - wt[i - 1]];
                    int ans2 = dp[i - 1][j];

                    dp[i][j] = Math.max(ans1, ans2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = price.length;
        int wt[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        // int ans = solve(price, n, wt, 8);
        // System.out.println("Result: " + ans);

        int ans = solve(price, n, wt, 8);
        System.out.println("Result: " + ans);
    }
}
