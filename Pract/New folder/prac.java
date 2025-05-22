import java.util.*;

public class prac {
    public static int binarySearch(int arr[]) {
        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == 0) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        // int mat[][] = { { 1, 1 },
        // { 1, 1 } };

        // int n = mat.length;
        // int m = mat[0].length;
        // int ans = 0;
        // for (int[] i : mat) {
        // int count = binarySearch(i);
        // if (count != -1)
        // ans += (count - 0 + 1);
        // }

        // System.out.println(ans);
        ////////////////////////////////////////////////////////////
        // int arr[] = { 1, 2, 1, 3, 4, 3 };
        // int num = arr[0];

        // for (int i = 1; i < arr.length; i++) {
        // num ^= arr[i];

        // // if(num==0)
        // // {
        // System.out.println(num);
        // // }
        // }

        // System.out.println(2 ^ 4);

        /////////////////////////////////////////////////////////////

        String str = "9";
        System.out.println((str.charAt(0) - '0') * 10);

    }
}