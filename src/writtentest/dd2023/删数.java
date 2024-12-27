package writtentest.dd2023;

import java.util.HashMap;
import java.util.Scanner;

public class 删数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = in.nextInt();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        long ans = 0;
        for (Integer key : map.keySet()) {
            Integer count = map.get(key);
            if (count > k) {
                ans += count - k;
            }
        }
        System.out.println(ans);

    }
}
