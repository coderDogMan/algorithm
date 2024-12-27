package week.week358;

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Q3 {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        TreeSet<Integer> set = new TreeSet<>();
        int ans = Integer.MAX_VALUE;
        for (int i = x; i < n; i++) {
            set.add(nums.get(i - x));
            int k = nums.get(i);

            Integer floor = set.floor(k);
            if (floor != null) {
                ans = Math.min(ans, k - floor);
            }
            Integer ceiling = set.ceiling(k);
            if (ceiling != null) {
                ans = Math.min(ans, ceiling - k);
            }
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
    }
}