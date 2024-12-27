package week.week352;

import java.util.PriorityQueue;

public class Q3 {
    public long continuousSubarrays(int[] nums) {
        PriorityQueue<Integer> min = new PriorityQueue<>((a, b) -> (a - b));
        PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> (b - a));
        int n = nums.length;
        int l = 0;
        long ans = 0;
        min.add(nums[0]);
        max.add(nums[0]);
        for (int i = 1; i < n; i++) {
            min.add(nums[i]);
            max.add(nums[i]);
            while (max.peek() - min.peek() > 2) {
                ans += (i - l);
                min.remove(nums[l]);
                max.remove(nums[l]);
                l++;
            }
        }
        long num = n - l;
        ans += (num + 1) * num / 2;

        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        q3.continuousSubarrays(new int[]{65,66,67,66,66,65,64,65,65,64});
//        q3.continuousSubarrays(new int[]{5,4,2,4});
    }
}