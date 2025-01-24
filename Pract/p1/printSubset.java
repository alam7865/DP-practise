import java.util.*;

public class printSubset {
    // public static void solve(int arr[], int n, ArrayList<Integer> list) {
    // if (n == 0) {
    // System.out.println(list.toString());
    // return;
    // }
    // solve(arr, n - 1, list);
    // ArrayList<Integer> newList = new ArrayList<>(list);
    // newList.add(arr[n - 1]);
    // solve(arr, n - 1, newList);

    // }

    // public static int solve(int arr[], int n, int count) {
    // if (n == 0) {
    // if (count == 7) {
    // return 1;
    // }

    // return 0;
    // }

    // int ans2 = solve(arr, n - 1, count);
    // int ans1 = solve(arr, n - 1, count |= arr[n - 1]);

    // return ans1 + ans2;
    // }

    ////////////// memoization ///////////////////

    public static int solve(int arr[], int n, int count, int dp[][]) {
        if (n == 0) {
            if (count == 2) {
                return 1;
            }

            return 0;
        }

        if (dp[n][count] != -1) {
            return dp[n][count];
        }
        int ans1 = solve(arr, n - 1, count, dp);
        int newCount = count | arr[n - 1];
        int ans2 = solve(arr, n - 1, newCount, dp);

        return dp[n][count] = ans2 + ans1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 2 };
        int n = arr.length;

        // ArrayList<Integer> list = new ArrayList<>();

        // solve(arr, n, list);

        ///////////////////////// solve ///////////////////
        // int ans = solve(arr, n, 0);

        int dp[][] = new int[n + 1][2 + 1];
        for (int[] i1 : dp) {
            Arrays.fill(i1, -1);
        }
        int ans = solve(arr, n, 0, dp);
        System.out.println("Result:" + ans);
    }
}
