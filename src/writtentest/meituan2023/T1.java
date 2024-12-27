package writtentest.meituan2023;

import java.text.DecimalFormat;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i ++) {
            int index = in.nextInt();
            String op = in.next();
            double ans = sum;
            ans -= nums[index - 1];
            ans -= nums[index];
            if (op.equals("+")) {
                ans += nums[index - 1] + nums[index];
            } else if (op.equals("-")) {
                ans += nums[index - 1] - nums[index];
            } else if (op.equals("*")) {
                ans += nums[index - 1] * nums[index];
            } else {
                ans += (double) nums[index - 1] / (double) nums[index];
            }
            String format = new DecimalFormat("#.0").format(ans);
            System.out.printf(format + " ");

        }
    }
}

