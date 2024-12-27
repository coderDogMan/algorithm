package writtentest.jd2023.jd2023_9_23;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[][] other = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            other[i][0] = in.nextInt();
            other[i][1] = in.nextInt();
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(nums[i], nums[other[i][0] - 1] + nums[other[i][1] - 1]);
        }
        System.out.println(ans);
    }
}
