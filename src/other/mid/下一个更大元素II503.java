package other.mid;

import java.util.Arrays;
import java.util.LinkedList;

public class 下一个更大元素II503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < 2 * n; i++) {
            if (!stack.isEmpty() && nums[i % n] > stack.getLast()) {
                while (!stack.isEmpty() && nums[i % n] > nums[stack.getLast()]) {
                    ans[stack.pollLast()] = nums[i % n];
                }
                stack.add(i % n);
            } else {
                stack.add(i % n);
            }
        }
        return ans;
    }
}


class Test21 {
    public static void main(String[] args) {
        下一个更大元素II503 test = new 下一个更大元素II503();
        test.nextGreaterElements(new int[]{1,2,1});
    }
}