package week.week.year2023;

import java.util.LinkedList;

public class 找出最具竞争力的子序列1673 {
    public int[] mostCompetitive(int[] nums, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || (stack.getLast() <= nums[i] && stack.size() < k)) {
                stack.add(nums[i]);
            } else {
                if (stack.size() >= k && stack.getLast() <= nums[i]) continue;
                int inNum = stack.size();
                int outNum = n - i;
                while (!stack.isEmpty() && stack.getLast() > nums[i] && inNum + outNum > k) {
                    stack.pollLast();
                    inNum--;
                }
                stack.addLast(nums[i]);

            }
        }
        int[] ans = stack.stream().mapToInt(Integer::intValue).toArray();
        return ans;

    }
}

class Test59 {
    public static void main(String[] args) {
        找出最具竞争力的子序列1673 test = new 找出最具竞争力的子序列1673();
        test.mostCompetitive(new int[]{2,4,3,3,5,4,9,6}, 4);
    }
}