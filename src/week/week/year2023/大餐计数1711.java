package week.week.year2023;

import java.util.HashMap;

public class 大餐计数1711 {
    public static final int MOD = (int) 1e9 + 7;
    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : deliciousness) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int[] pow = new int[22];
        pow[0] = 1;
        for (int i = 1; i <= 21; i++) {
            pow[i] = pow[i - 1] * 2;
        }
        long ans = 0;
        for (Integer key : map.keySet()) {
            for (int i = 0; i <= 21; i++) {
                if (map.containsKey(pow[i] - key)) {
                    if (key == pow[i] - key) {
                        ans = (ans + C(map.get(key), 2)) % MOD;
                    } else {
                        ans = (ans + map.get(key) * map.get(pow[i] - key)) % MOD;
                    }
                }
            }
            map.put(key, 0);
        }
        return (int) ans;
    }

    private long C(long a, int b) {
        if (b > a) return 0;
        return a * (a - 1) / 2;
    }
}

class Test47 {
    public static void main(String[] args) {
        大餐计数1711 test = new 大餐计数1711();
//        int[] nums = {64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64, 64};
//        System.out.println(nums.length);
        test.countPairs(new int[]{1048576,1048576});
    }
}


