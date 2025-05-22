import java.util.*;

public class coinChange {

    public static int mins = Integer.MAX_VALUE;

    public static int solve(int coins[], int sum, int n, int count) {
        if (sum == 0) {
            mins = Math.min(mins, count);
            return 1;
        }
        if (n == 0 || sum < 0) {
            return 0;
        }

        if (coins[n - 1] <= sum) {
            int ans1 = solve(coins, sum - coins[n - 1], n, count + 1);
            int ans2 = solve(coins, sum, n - 1, count);

            return Math.min(ans1, ans2);
        } else {
            return solve(coins, sum, n - 1, count);
        }
    }

    public static void main(String[] args) {
        int coins[] = { 25, 10, 5 };
        int sum = 30;

        int ans = solve(coins, 30, coins.length, 0);
        System.out.println("Result: " + ans);
        System.out.println("ANS: " + mins);
    }
}
