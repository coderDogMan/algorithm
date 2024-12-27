package week.weektwo110;

import java.util.*;

public class Q3 {
    public int minimumSeconds(List<Integer> nums) {
        int n = nums.size();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n * 2; i++) {
            int x = nums.get(i % n);
            if (!map.containsKey(x)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(x, list);
            } else {
                map.get(x).add(i);
            }
        }
        int ans = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            ArrayList<Integer> list = map.get(key);
            int m = list.size();
            int max = 0;
            for (int i = 1; i < m; i++) {
                max = Math.max(max, list.get(i) - list.get(i - 1) - 1);
            }
            ans = Math.min(ans, (max + 1) / 2);
        }

        return ans;
    }
}

class Test4 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(19);
        list.add(8);
        list.add(12);
        q3.minimumSeconds(list);
    }
}
