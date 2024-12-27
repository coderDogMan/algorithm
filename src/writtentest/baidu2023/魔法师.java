package writtentest.baidu2023;

import java.util.Scanner;

public class 魔法师 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int val = 1;
        //负数
        int ans1 = 0;
        //正数
        int ans2 = 0;
        int z = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            val *= nums[i] > 0 ? 1 : - 1;
            if (val > 0) {
                ans1 += f;
                ans2 += z + 1;
                z++;
            } else {
                ans1 += z + 1;
                ans2 += f;
                f++;
            }
        }
        //负数 正数 方案
        System.out.println(ans1 + " " + ans2);
    }
}
