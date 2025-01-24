import java.util.*;

public class minCoin {

    public static void solve(int target, int arr[], int n, ArrayList<Integer> list) {
        if (target == 0 || n == 0) {
            return;
        }

        if (arr[n - 1] <= target) {
            list.add(arr[n - 1]);
            solve(target - arr[n - 1], arr, n, list);
        } else {
            solve(target, arr, n - 1, list);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int target = 43;
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();

        solve(target, arr, n, list);

        System.out.println(list.toString());
    }
}
