import java.util.*;

public class knapsac {

    // public static int solve(int val[], int wt[], int capacity, int n) {
    // if (n == 0 || capacity == 0) {
    // return 0;
    // }

    // if (wt[n - 1] <= capacity) {
    // // include
    // int include = val[n - 1] + solve(val, wt, capacity - wt[n - 1], n - 1);

    // // not include
    // int exclude = solve(val, wt, capacity, n - 1);

    // return Math.max(include, exclude);
    // } else {
    // return solve(val, wt, capacity, n - 1);
    // }
    // }

    ////////////////////////////// memoization ///////////////////////////

    // public static int solve(int val[], int wt[], int capacity, int n, int
    // mat[][]) {
    // if (n == 0 || capacity == 0) {
    // return 0;
    // }

    // if (mat[n][capacity] != -1) {
    // return mat[n][capacity];
    // }

    // if (wt[n - 1] <= capacity) {
    // // include
    // int include = val[n - 1] + solve(val, wt, capacity - wt[n - 1], n - 1, mat);

    // // exclude;
    // int exclude = solve(val, wt, capacity, n - 1, mat);

    // return Math.max(include, exclude);
    // } else {
    // return solve(val, wt, capacity, n - 1, mat);
    // }
    // }

    //////////////////////////////// Tbulation ////////////////////////
    public static int solve(int val[], int wt[], int capacity, int n) {
        int mat[][] = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                int wt1 = wt[i - 1];
                int val1 = val[i - 1];

                if (wt1 <= j) {
                    // include
                    int include = val1 + mat[i - 1][j - wt1];
                    // exclude
                    int exclude = mat[i - 1][j];
                    mat[i][j] = Math.max(include, exclude);
                } else {
                    mat[i][j] = mat[i - 1][j];
                }
            }
        }

        return mat[n][capacity];
    }

    public static void main(String[] args) {
        int capacity = 4;
        int val[] = { 1, 2, 3 };
        int wt[] = { 4, 5, 1 };
        int n = val.length;
        // int ans = solve(val, wt, capacity, val.length);

        // System.out.println("Result: " + ans);

        ///////////////////////////// memoization //////////////////////////
        // int mat[][] = new int[n + 1][capacity + 1];
        // for (int i[] : mat) {
        // Arrays.fill(i, -1);
        // }

        // int ans = solve(val, wt, capacity, n, mat);
        // System.out.println("Result: " + ans);

        //////////////////////////////// Tabulation /////////////////////////
        int ans = solve(val, wt, capacity, val.length);

        System.out.println("Result: " + ans);

    }
}