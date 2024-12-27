package week.week358;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Q1 {
    public int maxSum(int[] nums) {
        int n = nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int max1 = 0;
                for (char c : String.valueOf(nums[i]).toCharArray()) {
                    max1 = Math.max(max1, c - 'a');
                }
                int max2 = 0;
                for (char c : String.valueOf(nums[j]).toCharArray()) {
                    max2 = Math.max(max2, c - 'a');
                }
                if (max1 != max2) continue;

                int sum = nums[i] + nums[j];
                list.add(sum);
            }
        }
        Collections.sort(list, (a, b) -> (b - a));
        if (list.size() > 0) return list.getFirst();
        return -1;
    }
}

class Test1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        q1.maxSum(new int[]{51,71,17,24,42});
    }
}