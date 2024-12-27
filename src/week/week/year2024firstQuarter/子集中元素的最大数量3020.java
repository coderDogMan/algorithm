package week.week.year2024firstQuarter;

import java.util.HashMap;

public class 子集中元素的最大数量3020 {
    int INF = (int) 1e9;
    public int maximumLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        int max = 0;
        if (map.get(1) != null) max = map.get(1) % 2 == 0 ? map.get(1) - 1 : map.get(1);
        for (Integer key : map.keySet()) {
            if (key == 1) continue;
            long x = key;
            int ans = 0;
            while (x <= INF && map.get((int)x) != null && map.get((int)x) >= 2) {
                x = x * x;
                ans += 2;
            }
            if (x > INF || map.get((int)x) == null) ans = ans - 1;
            else ans = ans + 1;
            max = Math.max(max, ans);
        }
        return max;
    }
}
class Test1 {
    public static void main(String[] args) {
        子集中元素的最大数量3020 t1 = new 子集中元素的最大数量3020();
        t1.maximumLength(new int[]{14,14,196,196,38416,38416});
//        t1.maximumLength(new int[]{5,4,1,2,2});

    }
}
