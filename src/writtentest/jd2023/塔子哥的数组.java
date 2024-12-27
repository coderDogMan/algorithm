package writtentest.jd2023;

import java.util.Scanner;

public class 塔子哥的数组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int num = in.nextInt();
            if (num == i) count++;
            nums[i] = num;
        }
        int ans = n;
        for (int i = 1; i < n; i++) {
            int t = count;
            if (i == nums[i]) {
                t -= 1;
            }
            if (i + 1 == nums[i + 1]) {
                t -= 1;
            }
            if (i + 1 == nums[i]) {
                t += 1;
            }
            if (i == nums[i + 1]) {
                t += 1;
            }
            //总数 - 正序对的最小值
            ans = Math.min(ans, n - t);
        }

        System.out.println(ans);
    }
}
