package niuke.week.Round34;

import java.util.Arrays;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i + 1 != nums[i]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1 + " " + 3);


    }

}
