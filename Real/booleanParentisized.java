import java.util.*;

public class booleanParentisized {
    public static HashMap<String, Integer> map = new HashMap<>();

    public static int solve(String str, int i, int j, boolean res) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            if (res) {
                return str.charAt(i) == 'T' ? 1 : 0;
            } else {
                return str.charAt(i) == 'F' ? 1 : 0;
            }
        }

        String key = i + " " + j + " " + res;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int ans = 0;

        for (int k = i + 1; k <= j - 1; k += 2) {
            int lt = solve(str, i, k - 1, true);
            int lf = solve(str, i, k - 1, false);
            int rt = solve(str, k + 1, j, true);
            int rf = solve(str, k + 1, j, false);

            char op = str.charAt(k);

            // int ans = 0;

            // for (int k = i + 1; k <= j - 1; k = k + 2) {
            // int lt = solve(str, i, k - 1, true);
            // int lf = solve(str, i, k - 1, false);
            // int rt = solve(str, k + 1, j, true);
            // int rf = solve(str, k + 1, j, false);

            // char op = str.charAt(k);

            if (op == '&') {
                if (res) {
                    ans += lt * rt;
                } else {
                    ans += (lt * rf) + (lf * rt) + (lf * rf);
                }
            } else if (op == '|') {
                if (res) {
                    ans += (lt * rt) + (lt * rf) + (lf * rt);
                } else {
                    ans += lf * rf;
                }
            }
            if (op == '^') {
                if (res) {
                    ans += (lt * rf) + (lf * rt); // XOR should be lt*rf + lf*rt for true
                } else {
                    ans += (lt * rt) + (lf * rf); // XOR should be lt*rt + lf*rf for false
                }
            }
        }
        map.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        String str = "T|F&T^T";
        int i = 0;
        int j = str.length() - 1;
        int ans = solve(str, i, j, true);
        System.out.println("Result: " + ans);
    }
}
