package week.week.year2024firstQuarter;

import java.util.*;

public class 避免洪水泛滥1488 {

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        TreeSet<Integer> set = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                set.add(i);
            } else {
                ans[i] = -1;
                if (map.containsKey(rains[i])) {
                    Integer ceiling = set.ceiling(map.get(rains[i]));
                    if (ceiling == null) return new int[]{};
                    set.remove(ceiling);
                    ans[ceiling] = rains[i];
                }
                map.put(rains[i], i);
            }
        }
        return ans;
    }
}

class Test27 {
    public static void main(String[] args) {
        避免洪水泛滥1488 test = new 避免洪水泛滥1488();
        test.avoidFlood(new int[]{1,2,0,0,2,1});
    }
}