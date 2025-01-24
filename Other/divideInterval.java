import java.util.*;

public class divideInterval {
    public static void main(String[] args) {
        int mat[][] = {
                { 5, 10 },
                { 6, 8 },
                { 1, 5 },
                { 2, 3 },
                { 1, 10 }
        };

        int max = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < mat.length; i++) {
            min = Math.min(min, mat[i][0]);
            min = Math.min(min, mat[i][1]);

            max = Math.max(max, mat[i][0]);
            max = Math.max(max, mat[i][1]);
        }

        System.out.println(min);
        System.out.println(max);

        int arr[] = new int[max + 1];

        for (int i = 0; i < mat.length; i++) {
            int m1 = mat[i][0];
            int m2 = mat[i][1];

            arr[m1]++;
            arr[m2]++;
        }

        int count = 0;
        for (int i = 0; i < max + 1; i++) {
            if (arr[i] > 1) {
                count++;
            }
        }

        System.out.println("result: " + count);
    }
}
