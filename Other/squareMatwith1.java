import java.util.*;

public class squareMatwith1 {

    // public static int solve(int mat[][], int i, int j) {
    // if (i < 0 || j < 0 || mat[i][j] == 0) {
    // return 0;
    // }

    // int left1 = solve(mat, i - 1, j);
    // int left2 = solve(mat, i, j - 1);
    // int left3 = solve(mat, i - 1, j - 1);

    // return 1 + Math.min(left1, Math.min(left2, left3));
    // }

    /////////////////////////////// Memoization code //////////////////////
    // public static int solve(int mat[][], int i, int j, int dp[][]) {
    // if (i < 0 || j < 0 || mat[i][j] == 0) {
    // return 0;
    // }

    // if (dp[i][j] != -1) {
    // return dp[i][j];
    // }

    // int left1 = solve(mat, i - 1, j, dp);
    // int left2 = solve(mat, i, j - 1, dp);
    // int left3 = solve(mat, i - 1, j - 1, dp);

    // return 1 + Math.min(left1, Math.min(left2, left3));
    // }

    /////////////////////////////////// Tabulation code //////////////////////
    public static int countSquares(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int totalSquares = 0;

        // Create a DP table to store the size of the largest square submatrix ending at
        // each cell
        int[][] dp = new int[rows][cols];

        // Iterate through each cell in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Only process cells that are 1
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        // Cells in the first row or first column can only form 1x1 squares
                        dp[i][j] = 1;
                    } else {
                        // Calculate the size of the square ending at (i, j)
                        dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    }
                    // Accumulate the count of squares
                    totalSquares += dp[i][j];
                }
            }
        }
        return totalSquares;
    }

    public static void main(String[] args) {
        int mat[][] = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };

        int n = mat.length;
        int m = mat[0].length;

        //////////////////////// recursive code ////////////////////////////////
        // int count = 0;

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // count += solve(mat, i, j);
        // }
        // }

        // System.out.println("Result: " + count);

        ////////////////////////// memoization code ///////////////////////////////

        // int dp[][] = new int[n + 1][m + 1];
        // int count = 0;
        // for (int[] i1 : dp) {
        // Arrays.fill(i1, -1);
        // }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // count += solve(mat, i, j, dp);
        // }
        // }

        // System.out.println("Result1: " + count);

        ////////////////////////////// Tabulation code ///////////////////////////
        int ans = countSquares(mat);
        System.out.println("Result: " + ans);
    }
}
