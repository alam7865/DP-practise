import java.util.*;

public class gridFish {
    public static void main(String[] args) {
        int mat[][] = {
                { 0, 2, 1, 0 },
                { 4, 0, 0, 3 },
                { 1, 0, 0, 4 },
                { 0, 3, 2, 0 }
        };

        int row[] = new int[mat.length];
        int[] col = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            int max = 0;
            int sum = mat[i][0];
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    sum += mat[i][j];
                } else {
                    max = Math.max(max, sum);
                    sum = 0;
                }
            }
            max = Math.max(max, sum);

            row[i] = max;
        }

        int x = 0;
        for (int i = 0; i < mat.length; i++) {
            int max = 0;
            int sum = mat[0][i];
            for (int j = 1; j < mat[0].length; j++) {
                if (mat[j][i] != 0) {
                    sum += mat[j][i];
                } else {
                    max = Math.max(max, sum);
                    sum = 0;
                }
            }
            max = Math.max(max, sum);

            col[x++] = max;
        }

        System.out.println(Arrays.toString(col));
    }
}
