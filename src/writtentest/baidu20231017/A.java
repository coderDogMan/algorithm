package writtentest.baidu20231017;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
//        LinkedList<Integer> stack = new LinkedList<>();
        int ans = 0;
//        stack.add(0);
//        for (int i = 0; i < n; i++) {
//            if (nums[i] % 2 == 1) {
//                Integer last = stack.pollLast();
//                ans += (i - last);
//                stack.add(last + 1);
//            }
//        }
        int last = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 1) {
                ans += i - last;
                last++;
            }
        }

        System.out.println(ans);
    }
}
