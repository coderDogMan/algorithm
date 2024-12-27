package writtentest.xiaomi2023;

import java.util.Arrays;
import java.util.Scanner;

public class 执行任务 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(",");
        int n = s.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] split = s[i].split(":");
            nums[i][0] = Integer.parseInt(split[0]);
            nums[i][1] = Integer.parseInt(split[1]);
        }
        Arrays.sort(nums, (a, b) -> {
            return (b[1] - b[0]) - (a[1] - a[0]);
        });
        int need = 0;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (cur < nums[i][1]) {
                need += (nums[i][1] - cur);
                cur = nums[i][1] - nums[i][0];
            } else {
                cur -= nums[i][0];
            }
        }

        if (need > 4800) {
            System.out.println(-1);
        } else {
            System.out.println(need);
        }

    }
}
