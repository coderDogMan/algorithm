package writtentest.jd2023.jd2023_9_23;

import java.util.LinkedList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; ) {
            int j = i + 1;
            while (j < n && nums[j] >= nums[j - 1]) {
                j++;
            }
            int num = j - i;
            if (num >= 3) {
                ans += (num / 3) + (num % 3 >= 2 ? 1 : 0);
            }
            i = j;
        }
        System.out.println(ans);
    }



}
