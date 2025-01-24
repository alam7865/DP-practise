import java.util.*;

public class str1 {
    public static void main(String[] args) {
        String target = "he";
        String str = "abcdefghijklmnopqrstuvwxyz";
        char arr[] = str.toCharArray();

        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int xxxxx = 1;
        for (int i = 0; i < target.length(); i++) {
            char ch1 = target.charAt(i);

            char ch2 = 'a';
            sb.append(ch2);
            list.add(sb.toString());
            // System.out.println(list.toString());

            if (ch2 == ch1) {
                continue;
            }
            // System.out.println("ggggggg");
            int idx = sb.length() - 1;
            for (int j = 1; j < arr.length; j++) {

                char ch3 = arr[j];

                sb.setCharAt(idx, ch3);
                list.add(sb.toString());
                if (ch3 == ch1) {
                    break;
                }
                // System.out.println(sb.toString());
            }
            // idx++;

        }

        System.out.println(list.toString());
    }
}
