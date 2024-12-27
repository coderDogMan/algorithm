package week.week339;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class 等值距离和2615 {
    public long[] distance(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = nums.length;
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        for (Integer key : map.keySet()) {
            ArrayList<Integer> list = map.get(key);
            int m = list.size();
            long[] preSum = new long[m + 1];
            for (int i = 1; i <= m; i++) {
                preSum[i] = preSum[i - 1] + list.get(i - 1);
            }
            for (int i = 0; i < m; i++) {
                int idx = list.get(i);
                long left = (long) idx * i - preSum[i];
                long right = preSum[m] - preSum[i] - (long) idx * (m - i);
                ans[idx] = left + right;
            }
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
        等值距离和2615 test = new 等值距离和2615();
        test.distance(new int[]{1,3,1,1,2});
    }
}