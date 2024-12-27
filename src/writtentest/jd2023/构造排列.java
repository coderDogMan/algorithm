package writtentest.jd2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 构造排列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long[] nums = new long[n];
        long ans = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextLong();
        }
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > k) {
                if (stack.isEmpty())
                    stack.add(i);
            } else if (!stack.isEmpty()){
                num++;
                int last = stack.pollLast();
                ans += i - last;
                stack.add(last + 1);
            } else {
                num++;
            }
            if (num == k) break;
        }
        System.out.println(ans);
    }
}
