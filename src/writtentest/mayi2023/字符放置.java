package writtentest.mayi2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 字符放置 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] chars = s.toCharArray();
        int n = chars.length;
        int b = 0;
        int r = 0;
        for (char c : chars) {
            if (c == '0') b++;
            else r++;
        }
        if (n <= 26) {
            for (int i = 0; i < n; i++) {
                System.out.print(i + 'a');
            }
        } else if (b >= 13 && r < 13) {
//            Math.floor()
        }else if (b < 13 &&r > 13) {

        }else if (b > 13 && r > 13) {

        }
//        11111111111111111000000000000000000000
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();

    }
}
