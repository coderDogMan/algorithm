package backtacking.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 组合总和39 {

    private List<List<Integer>> result = new ArrayList<>();
    private LinkedList path = new LinkedList();
    private int sum;

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

        public void backtracking(int[] candidates, int target, int startIndex) {
            if (sum > target) return;
            if (sum == target) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = startIndex; i < candidates.length; i++) {

                sum += candidates[i];
                if (sum > target) {
                    sum -= candidates[i];
                    break;
                }
                path.add(candidates[i]);
                backtracking(candidates, target, i);
                sum -= candidates[i];
                path.removeLast();
            }
        }

}
