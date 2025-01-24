import java.util.*;

public class toSmall {
    public static void main(String[] args) {
        int arr[] = { 4, 3, 1, 5, 6 };
        int n = arr.length;

        int smal1 = Integer.MIN_VALUE;
        int smal2 = Integer.MIN_VALUE;
        int max = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] > smal1) {
                smal2 = smal1;
                smal1 = arr[i];
            } else if (arr[i] > smal2) {
                smal2 = arr[i];
            }

            if (i >= 1) {
                max = Math.max(max, smal1 + smal2);
            }

            // System.out.println(smal1 + " " + smal2);
        }

        System.out.println(max);
    }
}
