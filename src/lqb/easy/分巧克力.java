package lqb.easy;

import java.util.Scanner;

public class 分巧克力 {
    static int left = 1;
    static int right = 100000;
    static int k;
    static int n;
    static int[] H;
    static int[] W;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        //人数
        k = in.nextInt();
        H = new int[n];
        W = new int[n];
        for (int i = 0; i < n; i++)
            H[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            W[i] = in.nextInt();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getSum(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
    private static boolean getSum(int b) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (H[i] / b) * (W[i] / b);
            if (ans > k) {
                return true;
            }
        }
        return false;
    }
}
