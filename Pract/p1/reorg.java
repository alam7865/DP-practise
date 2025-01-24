import java.util.*;

public class reorg {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list5 = new ArrayList<>();
        // -1, -1, 6, 1, 9, 3, 2, -1, 4, -1
        list1.add(-1);
        list1.add(-1);
        list1.add(6);
        list1.add(1);
        list1.add(9);
        list1.add(3);
        list1.add(2);
        list1.add(-1);
        list1.add(4);
        list1.add(-1);

        // for (int i : list1) {
        // list5.set(i, -1);
        // }

        for (int i = 0; i < list1.size(); i++) {
            list5.add(-1);
        }

        for (int i = 0; i < list1.size(); i++) {
            int val = list1.get(i);

            if (val != -1) {
                list5.set(val, val);
            }
        }

        System.out.println(list5.toString());
    }
}
