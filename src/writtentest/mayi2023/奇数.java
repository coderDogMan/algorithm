package writtentest.mayi2023;

import java.util.HashMap;
import java.util.Scanner;

public class 奇数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (Integer key : map.keySet()) {
            if ((key & 1) == 1 && (map.get(key) & 1) == 1) {
                ans += map.get(key);
            }
        }
        System.out.println(ans);
    }
}
