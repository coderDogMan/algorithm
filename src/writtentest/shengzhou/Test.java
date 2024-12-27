package writtentest.shengzhou;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        int y = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);
        int[] nums = new int[13];
        nums[1] = 31;
        if (y % 4 == 0) {
            nums[2] = 29;
        } else {
            nums[2] = 28;
        }
        nums[3] = 31;
        nums[4] = 30;
        nums[5] = 31;
        nums[6] = 30;
        nums[7] = 31;
        nums[8] = 31;
        nums[9] = 30;
        nums[10] = 31;
        nums[11] = 30;
        nums[12] = 31;
        int ans = 0;
        for (int i = 1; i < m; i++) {
            ans += nums[i];
        }
        System.out.println(ans + d);
    }
}
