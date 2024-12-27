package week.week.year2023;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 摧毁一系列目标2453 {
    public int destroyTargets(int[] nums, int space) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int key = num % space;
            if (map.containsKey(key)) {
                map.get(key).add(num);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(num);
                map.put(key, list);
            }
        }
        int len = 0;
        int ans = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            ArrayList<Integer> list = map.get(key);
            if (list.size() > len) {
                len = list.size();
                Collections.sort(list);
                ans = list.get(0);
            } else if (list.size() == len) {
                len = list.size();
                Collections.sort(list);
                ans = Math.min(ans, list.get(0));
            }
        }
        return ans;
    }
}

class Test23 {
    public static void main(String[] args) {
        摧毁一系列目标2453 test = new 摧毁一系列目标2453();
        test.destroyTargets(new int[]{1,5,3,2,2}, 10000);
    }
}