import java.util.*;

public class isSubsequence {

    public static int binarySearch(ArrayList<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (list.get(mid) > target) {
                ans = list.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str1 = "dsahjpjauf";
        String str2 = "ahbwzgqnuk";

        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char ch1 = str1.charAt(i);
            // int idx = i;

            if (map.containsKey(ch1)) {
                ArrayList<Integer> list = map.get(ch1);
                list.add(i);
                map.put(ch1, list);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(ch1, list);
            }
        }

        // ArrayList<Integer> list = map.get('a');
        // System.out.println(list.toString());

        int idx = -1;
        for (int i = 0; i < str2.length(); i++) {
            char ch1 = str2.charAt(i);
            if (!map.containsKey(ch1)) {
                System.out.println("NOT Found");
                break;
            } else {
                ArrayList<Integer> list = map.get(ch1);
                int res = binarySearch(list, idx);
                if (res == -1) {
                    System.out.println("NOT FOUND");
                    break;
                }
                idx = res;
                System.out.println(res);
            }

        }
    }
}
