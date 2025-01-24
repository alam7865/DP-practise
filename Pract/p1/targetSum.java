import java.util.*;

public class targetSum {

    // public static int count = 0;

    // public static boolean solve(int num[], int target, int n) {
    // if (target == 0) {
    // count++;
    // return true;
    // }

    // if (n == 0) {
    // return false;
    // }

    // if (num[n] <= target) {
    // // Include
    // boolean ans1 = solve(num, target - num[n], n - 1);
    // // Exclude
    // boolean ans2 = solve(num, target, n - 1);

    // return ans1 || ans2;
    // } else {
    // return solve(num, target, n - 1);
    // }
    // }

    ///////////////////////////////////////////////////////////////////////
    public static int count = 0;
    static int[][] dp;

    public static int solve(int num[], int target, int n) {
        if (target == 0) {
            count++;
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        if (dp[n][target] != -1) {
            return dp[n][target];
        }

        if (num[n - 1] <= target) {
            // Include
            int ans1 = solve(num, target - num[n - 1], n - 1);
            // Exclude
            int ans2 = solve(num, target, n - 1);

            if (ans1 == 1 || ans2 == 1) {
                dp[n][target] = 1;
            } else {
                dp[n][target] = 0;
            }
        } else {
            int ans1 = solve(num, target, n - 1);
            if (ans1 == 1) {
                dp[n][target] = 1;
            } else {
                dp[n][target] = 0;
            }
        }

        return dp[n][target];
    }

    public static void main(String args[]) {
        int num[] = { 4, 2, 7, 1, 3 };
        int target = 10;

        // boolean ans = solve(num, target, num.length - 1);
        // System.out.println("Result: " + ans);
        // System.out.println(count);

        dp = new int[num.length + 1][target + 1];

        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        int ans = solve(num, target, num.length);
        System.out.println(ans);
        System.out.println("Count: " + count);
    }
}