import java.util.*;

public class chair {
    public static void main(String[] args) {
        int mat[][] = {
                { 3, 10 },
                { 1, 5 },
                { 2, 6 }
        };

        Arrays.sort(mat, Comparator.comparingDouble(o -> o[0]));
        for (int[] i1 : mat) {
            System.out.println(Arrays.toString(i1));
            System.out.println();
        }
    }
}
