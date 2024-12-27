package writtentest.笔试360;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {
    static int[] nums;
    static int[] val;
    static long[] memo;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        val = new int[4];
        nums = new int[n];
        for (int i = 0; i < 4; i++) val[i] = in.nextInt();
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();
        memo = new long[n];
        Arrays.fill(memo, -1);

        System.out.println(dfs(0));
    }

    private static long dfs(int i) {
        if (i > nums.length) return Long.MAX_VALUE / 2;
        if (i == nums.length) return 0;
        if (memo[i] != -1) return memo[i];

        long res = dfs(i + 1) + nums[i];
        res = Math.min(res, dfs(i + 1) + val[0]);
        res = Math.min(res, dfs(i + 30) + val[1]);
        res = Math.min(res, dfs(i + 365) + val[2]);
        res = Math.min(res, dfs(i + 3650) + val[3]);

        return memo[i] = res;
    }
}
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class T2 {
//    static int[] nums;
//    static int[] val;
//    static int[][] memo;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n  = in.nextInt();
//        val = new int[4];
//        nums = new int[n];
//        for (int i = 0; i < 4; i++) val[i] = in.nextInt();
//        for (int i = 0; i < n; i++) nums[i] = in.nextInt();
//        memo = new int[n][3650];
//        for (int i = 0; i < n; i++)
//            Arrays.fill(memo[i], -1);
//        System.out.println(dfs(n - 1, 0));
//
//    }
//
//    private static int dfs(int i, int day) {
//        if (i < 0) return 0;
//        if (memo[i][day] != -1) return memo[i][day];
//
//        int res = dfs(i - 1, Math.max(0, day - 1)) + nums[i];
//        if (day > 0) {
//            res = dfs(i - 1, day - 1);
//        } else {
//            res = Math.min(res, dfs(i - 1, 0) + val[0]);
//            res = Math.min(res, dfs(i - 1, 29) + val[1]);
//            res = Math.min(res, dfs(i - 1, 364) + val[2]);
//            res = Math.min(res, dfs(i - 1, 3649) + val[3]);
//        }
//
//        return memo[i][day] = res;
//    }
//}
