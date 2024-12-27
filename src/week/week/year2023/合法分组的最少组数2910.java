package week.week.year2023;

import java.util.HashMap;

public class 合法分组的最少组数2910 {
    public int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.merge(num,1, Integer::sum);
        int[] values = map.values().stream().mapToInt(Integer::intValue).toArray();
        int min = Integer.MAX_VALUE;
        for (int value : values) {
            min = Math.min(min, value);
        }
        for (int k = min; k > 0; k--) {
            int ans = 0;
            for (int value : values) {
                int c = value / k;
                int m = value % k;
                if (m > c) {
                    ans = 0;
                    break;
                }
                ans += (value + k) / (k + 1);
            }
            if (ans > 0) return ans;
        }
        return -1;
    }
}

class Test94 {
    public static void main(String[] args) {
        合法分组的最少组数2910 test = new 合法分组的最少组数2910();
        System.out.println(test.minGroupsForValidAssignment(new int[]{10,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,110,10,10,3,1,1}));
        System.out.println(test.minGroupsForValidAssignment(new int[]{10, 10, 10, 3, 1, 1}));

    }
}