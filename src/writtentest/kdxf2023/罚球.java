package writtentest.kdxf2023;

import java.util.Scanner;

public class 罚球 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = in.nextInt();
        int l = 0;
        int ans = Integer.MAX_VALUE;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            while (cur >= k) {
                ans = Math.min(ans, i - l + 1);
                cur -= nums[l++];
            }
        }
        System.out.println(ans);


    }
}
