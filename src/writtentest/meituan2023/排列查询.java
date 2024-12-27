package writtentest.meituan2023;

import java.util.HashMap;
import java.util.Scanner;

public class 排列查询 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            map.put(x, i);
        }
        int x = in.nextInt();
        int y = in.nextInt();
        Integer idx1 = map.get(x);
        Integer idx2 = map.get(y);
        if (idx1 == null || idx2 == null || Math.abs(idx1 - idx2) != 1)
            System.out.println("No");
        else System.out.println("Yes");

    }
}
