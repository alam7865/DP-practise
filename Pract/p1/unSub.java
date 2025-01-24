import java.util.*;

public class unSub {
    public static void main(String[] args) {
        String str = "abcd";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String ss = str.substring(i, j);
                System.out.println(ss);
                // HashMap<Character, Integer> map = new HashMap<>();
                // int istwice = 0;
                // for (int k = 0; k < ss.length(); k++) {
                // char ch = ss.charAt(k);
                // map.put(ch, map.getOrDefault(ch, 0) + 1);
                // // System.out.println(map.get(ch));
                // if (map.get(ch) > 1) {
                // istwice = 1;
                // break;
                // }
                // }

                // if (istwice == 0) {
                // count++;
                // }
                // break;

            }
        }

        System.out.println("Result: " + count);
    }
}
