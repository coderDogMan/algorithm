package week.week339;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class 美丽子集的数目2597 {
//    LinkedList<LinkedList<Integer>> ans = new LinkedList<>();
    int ans;
    LinkedList<Integer> path = new LinkedList<>();
    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int[] vis = new int[1001];
        dfs(nums, k, 0,  vis);
        return ans;
    }

    private void dfs(int[] nums, int k, int startIndex, int[] vis) {
        if (path.size() > 0) ans++;
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] - k >= 0 && vis[nums[i] - k] != 0) continue;
            path.add(nums[i]);
            vis[nums[i]]++;
            dfs(nums, k, i + 1, vis);
            path.removeLast();
            vis[nums[i]]--;
        }
    }
}

class Test12 {
    public static void main(String[] args) {
        美丽子集的数目2597 test = new 美丽子集的数目2597();
        test.beautifulSubsets(new int[]{10,4,5,7,2,1}, 3);
//        test.beautifulSubsets(new int[]{2,4,6}, 2);

    }
}