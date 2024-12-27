package week.week.year2024firstQuarter;

import writtentest.huawei2023.分配资源ID;

import java.util.HashMap;

public class NumArray {
    int[] nums;
    int[] tree;
    public NumArray(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }

    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        for (int i = index + 1; i < tree.length; i += (i & -i)) {
            tree[i] += diff;
        }
    }



    public int sumRange(int left, int right) {
        return prefixSum(right + 1) - prefixSum(left);
    }

    private int prefixSum(int i) {
        int res = 0;
        for (; i > 0; i -= (i & -i)) {
            res += tree[i];
        }
        return res;
    }


    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
