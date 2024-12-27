package writtentest.szml;

import java.util.LinkedList;
import java.util.Scanner;

public class T1 {

    static LinkedList<LinkedList<Integer>> ans = new LinkedList<LinkedList<Integer>>();
    static LinkedList<Integer> path = new LinkedList<>();
    static int[] nums;
    static int n, m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        nums = new int[n];
        for (int i = 1; i <= n; i++) nums[i - 1] = i;
        dfs(0, 0);
        for (LinkedList<Integer> item : ans) {
            for (Integer x : item) System.out.print(x + " ");
            System.out.println();
        }
    }

    private static void dfs(int i, int sum) {
        if (i == n) {
            if (sum == m) ans.add(new LinkedList<>(path));
            return;
        }
        path.add(nums[i]);
        dfs(i + 1, sum + nums[i]);
        path.removeLast();
        dfs(i + 1, sum);


    }
}
