package writtentest.baidu2023;

import java.util.Scanner;

public class 染色数组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        String s = in.next();
        long r = 0;
        long b = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'R') {
                r += nums[i];
            } else {
                b += nums[i];
            }
        }
        r %= 1000000007;
        b %= 1000000007;
        System.out.println((r * b) % 1000000007);

    }
}
