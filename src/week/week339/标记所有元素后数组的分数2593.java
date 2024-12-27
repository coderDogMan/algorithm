package week.week339;

import java.util.Arrays;

public class 标记所有元素后数组的分数2593 {
    public long findScore(int[] nums) {
        int n = nums.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        Arrays.sort(ids, (a, b) -> (nums[a] - nums[b]));
        boolean[] vis = new boolean[n];
        long ans = 0;
        for (Integer id : ids) {
            if (vis[id]) continue;
            ans += nums[id];
            vis[id] = true;
            if (id - 1 >= 0) {
                vis[id - 1] = true;
            }
            if (id + 1 < n) {
                vis[id + 1] = true;
            }
        }
        return ans;
    }
}

class Test11 {
    public static void main(String[] args) {
        标记所有元素后数组的分数2593 test = new 标记所有元素后数组的分数2593();
        test.findScore(new int[]{2,3,5,1,3,2});
//        test.findScore(new int[]{2,1,3,4,5,2});
    }
}