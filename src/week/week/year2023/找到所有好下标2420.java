package week.week.year2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 找到所有好下标2420 {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        Arrays.fill(L, 1);
        Arrays.fill(R, 1);
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                L[i] += L[i - 1];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                R[i] += R[i + 1];
            }
        }
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 1; i < n - 1; i++) {
            if (L[i - 1] >= k && R[i + 1] >= k)
                ans.add(i);
        }
        return ans;


    }
}

class Test61 {
    public static void main(String[] args) {
        找到所有好下标2420 test = new 找到所有好下标2420();
        test.goodIndices(new int[]{878724,201541,179099,98437,35765,327555,475851,598885,849470,943442}, 4);
    }
}