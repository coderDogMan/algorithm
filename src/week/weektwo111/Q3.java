package week.weektwo111;


import writtentest.huawei2023.分配资源ID;

import java.util.*;

public class Q3 {

    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        Integer start = nums.get(0);
        dp[0][0] = start == 1 ? 0 : 1;
        dp[0][1] = start == 2 ? 0 : 1;
        dp[0][2] = start == 3 ? 0 : 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k <= j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k]) + ((nums.get(i) - 1) == j ? 0 : 1);
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    public int minimumOperations1(List<Integer> nums) {
        int n = nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums.get(j) <= nums.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return n - max;
    }
}
class Test3 {
    public static void main(String[] args) {
        Q3 test = new Q3();
        LinkedList<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
//        list.add(1);
        list.add(3);
        list.add(3);
//        list.add(1);
        test.minimumOperations(list);
    }
}
