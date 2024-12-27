package week.week338;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T3 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        LinkedList<Long> list = new LinkedList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int m = queries.length;
        long[] perSum = new long[nums.length + 1];
        for (int i = 1; i <= nums.length; i++)
            perSum[i] = perSum[i - 1] + nums[i - 1];

        for (int i = 0; i < m; i++) {
            long num = 0;
            long target = queries[i];
            int index = search(nums, target) + 1;
            num += Math.abs(perSum[index] - (index) * target);
            num += Math.abs(perSum[n] - perSum[index] - (n - index) * target);
            list.add(num);
        }
        return list;
    }
    public int search(int[] nums, long target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
//        t3.minOperations(new int[]{3,1,6,8}, new int[]{8});
        System.out.println(t3.search(new int[]{1, 3,3,3,3,3, 6, 8},  3));
        System.out.println(t3.search(new int[]{1, 3,3,3,3,3, 6, 8},  3));
    }
}

