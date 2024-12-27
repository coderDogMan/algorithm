package writtentest.huawei2023.od411;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int mid = nums[i];
            int left = i * mid - sum[i];
            int right = (sum[n] - sum[i]) - (n - i) * mid;
            if (right + left < min) {
                min = right + left;
                ans = nums[i];
            }
        }
        System.out.println(ans);
    }
}
