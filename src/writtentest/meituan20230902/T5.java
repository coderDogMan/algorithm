package writtentest.meituan20230902;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class T5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
            max = Math.max(max, map.get(x));
        }
        if (max < n / 2) {
            System.out.println(n / 2);
            return;
        }
        Integer[] keys = map.keySet().stream().toArray(Integer[]::new);
        Arrays.sort(keys, (a, b) -> (map.get(b) - map.get(a)));
        int ans = 0;
        for (int i = 0; i < keys.length; i++) {
            for (int j = i; j < keys.length; j++) {
                int lKey = keys[i];
                int rKey = keys[j];
                if (map.get(lKey) == 0) break;
                if (map.get(rKey) == 0 || (lKey == rKey && map.get(lKey) == 1)) continue;
                map.put(lKey, map.get(lKey) - 1);
                map.put(rKey, map.get(rKey) - 1);
                ans++;
            }
        }
        System.out.println(ans);


    }
}
