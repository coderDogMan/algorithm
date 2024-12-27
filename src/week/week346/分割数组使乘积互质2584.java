package week.week346;

import java.util.HashMap;
import java.util.Scanner;

public class 分割数组使乘积互质2584 {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        // 值 、 下标
        HashMap<Integer, Integer> left = new HashMap<>();
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int d = 2; d * d <= x; d++) {
                if (x % d == 0) {
                    if (left.containsKey(d)) {
                        right[left.get(d)] = i;
                    } else {
                        left.put(d, i);
                    }
                    for (x /= d; x % d == 0; x /= d);
                }
            }
            if (x > 1) {
                if (left.containsKey(x)) {
                    right[left.get(x)] = i;
                } else {
                    left.put(x, i);
                }
            }
        }

        for (int l = 0, max = 0; l < n; l++) {
            if (l > max) return max;
            max = Math.max(max, right[l]);
        }
        return -1;
    }
}


class Test4 {
    public static void main(String[] args) {
        分割数组使乘积互质2584 test = new 分割数组使乘积互质2584();
        test.findValidSplit(new int[]{4,7,15,8,3,5});
        test.findValidSplit(new int[]{4,7,8,15,3,5});
    }
}