import java.util.*;

public class pp {
    public static void main(String[] args) {
        String s = "azerdii";
        int k = 5;
        String res = "";
        int max = 0;
        int n = s.length();

        ArrayList<Character> list = new ArrayList<>();
        list.add('a');
        list.add('e');
        list.add('i');
        list.add('o');
        list.add('u');

        for (int i = 0; i <= n - k; i++) {
            String str = s.substring(i, i + k);

            System.out.println(str);
            // int count = 0;
            // for (int j = 0; j < str.length(); j++) {
            // char ch = str.charAt(j);

            // if (list.contains(ch)) {
            // count++;
            // }
            // }

            // if (count > max) {
            // max = count;
            // res = str;
            // }
        }

        // return res;
    }
}
