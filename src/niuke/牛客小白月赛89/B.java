package niuke.牛客小白月赛89;


import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            long[] nums = new long[n];
            for (int i = 0; i < n; i++) nums[i] = in.nextInt();
            Arrays.sort(nums);
            long sum = 0;
            for (int i = 0; i < n - 1; i++) sum = (sum * 2 + nums[i]);
            System.out.println(sum + nums[n - 1]);
        }
    }
}
