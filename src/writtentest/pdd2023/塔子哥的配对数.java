package writtentest.pdd2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 塔子哥的配对数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            int[] modMap = new int[m];
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer value = entry.getValue();
                ans += value / 2;
                if (value % 2 == 1) {
                    modMap[entry.getKey() % m]++;
                }
            }
            ans += (modMap[0] / 2);
            for (int i = 1; i <= m / 2; i++) {
                if (i == m - i && modMap[m - i] != 0) {
                    ans += modMap[i] / 2;
                    continue;
                }
                if (modMap[i] != 0 && modMap[m - i] != 0) {
                    ans += Math.min(modMap[i], modMap[m - i]);
                }
            }

            System.out.println(ans);
        }


    }
}
