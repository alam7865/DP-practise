import java.util.*;

public class maxSum {
    public static void main(String[] args) {
        int n = 12;

        int arr[] = new int[100 + 1];

        for (int i = 0; i <= 11; i++) {
            arr[i] = i;
        }

        for (int i = 12; i <= 100; i++) {
            int x = i / 2;
            int y = i / 3;
            int z = i / 4;

            int sum = arr[x] + arr[y] + arr[z];
            arr[i] = sum;
        }

        System.out.println(arr[12]);
    }
}
