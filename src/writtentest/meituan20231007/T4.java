package writtentest.meituan20231007;


import java.util.Scanner;

public class T4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        double ans = 1D;
        while (n-- > 0) {
            int m = in.nextInt();
            int[] nums = new int[m];
            for (int i = 0; i < m; i++) {
                nums[i] = in.nextInt();
            }
        }
        System.out.println(ans);
    }

}
