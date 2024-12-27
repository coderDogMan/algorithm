package backtacking.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合77 {
    private List<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public static void main(String[] args) {

    }

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return res;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == 2) {
            res.add(path);
            return;
        }

        for (int i = startIndex; i <= (n - k + path.size() + 1); i++) {
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }


    }
}
