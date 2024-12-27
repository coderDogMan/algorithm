package week.week.year2024firstQuarter;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 通过最少操作次数使数组的和相等1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum(), sum2 = Arrays.stream(nums2).sum();
        int target = Math.abs(sum1 - sum2);
        if (sum1 > sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n = nums1.length, m = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < n; i++) q.add(6 - nums1[i]);
        for (int i = 1; i < m; i++) q.add(nums1[i] - 1);
        int ans = 0;
        int sum = 0;
        while (sum < target && !q.isEmpty()) {
            sum += q.poll();
            ans++;
        }
        return sum >= target ? ans : -1;
    }
}
