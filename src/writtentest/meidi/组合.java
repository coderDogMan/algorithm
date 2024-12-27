package writtentest.meidi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 组合 {

    static LinkedList<LinkedList> ans = new LinkedList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static boolean[] used = new boolean[4];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        dfs(nums);
        System.out.println(ans.size());
    }

    private static void dfs(int[] nums) {
        if (path.size() == 3) {
            ans.add(new LinkedList(path));
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1] || used[i]) continue;
            path.add(i);
            used[i] = true;
            dfs(nums);
            used[i] = false;
            path.removeLast();
        }
    }
}
