package writtentest.baidu2023;

import java.util.Arrays;
import java.util.Scanner;

public class 排列数量 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        while (k-- > 0) {
            int n = in.nextInt();
            int[][] nums = new int[n][2];
            for (int i = 0; i < n; i++) {
                nums[i][0] = in.nextInt();
                nums[i][1] = i;
            }
            Arrays.sort(nums, (a, b) -> (a[0] - b[0]));
            int ans = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (nums[i][1] > max) {
                    max = nums[i][1];
                }
                if (nums[i][1] < min) {
                    min = nums[i][1];
                }
                if (max - min == i) {
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}

