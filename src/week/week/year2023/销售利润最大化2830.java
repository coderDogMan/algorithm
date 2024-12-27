package week.week.year2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 销售利润最大化2830 {

    List<List<Integer>> offers;
    LinkedList<int[]>[] nums;
    int[] memo;
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        this.offers = offers;
        nums = new LinkedList[n];
        memo = new int[n];
        Arrays.fill(memo, -1);
        Arrays.setAll(nums, e -> new LinkedList<>());
        for (int i = 0; i < offers.size(); i++) {
            int st = offers.get(i).get(0);
            int ed = offers.get(i).get(1);
            int v = offers.get(i).get(2);
            nums[st].add(new int[] {ed, v});
        }
        return dfs(0);
    }

    private int dfs(int i) {
        if (i >= nums.length) return 0;
        if (memo[i] != -1) return memo[i];
        int res = dfs(i + 1);
        for (int[] e : nums[i]) {
            res = Math.max(res, dfs(e[0] + 1) + e[1]);
        }
        memo[i] = res;
        return res;
    }

}

class Test101 {
    public static void main(String[] args) {
        销售利润最大化2830 test = new 销售利润最大化2830();
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        LinkedList<Integer> l3 = new LinkedList<>();
        l1.add(0);
        l1.add(0);
        l1.add(1);

        l1.add(0);
        l1.add(2);
        l1.add(2);
    }
}