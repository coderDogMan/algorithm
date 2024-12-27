package lqb.xiaobai6;

import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //在此输入您的代码...

        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[(i + n - 1) % n] + nums[(i + n + 1) % n] + " ");
        }
    }

}
