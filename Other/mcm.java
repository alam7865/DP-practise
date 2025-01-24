import java.util.*;

public class mcm {

    public static int solve(int arr[], int i, int j) {
        if (i >= j) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solve(arr, i, k) + solve(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            ans = Math.min(ans, temp);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 30, 5, 60 };
        int n = arr.length;

        int ans = solve(arr, 1, n - 1);
        System.out.println("Result: " + ans);
    }
}
