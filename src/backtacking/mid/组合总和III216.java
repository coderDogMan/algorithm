package backtacking.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合总和III216 {

    private static List<List<Integer>> res = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static int sum;

    public static void main(String[] args) {
        combinationSum3(3, 7);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return res;
    }

    public static void backtracking(int k, int n, int startIndex) {
        if (path.size() == k) {
            if (sum == n) res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            sum += i;
            path.add(i);
            backtracking(n, k, i + 1);
            sum -= i;
            path.removeLast();
        }
    }


}
