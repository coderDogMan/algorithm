package writtentest.jd2023;

import java.util.Scanner;

public class 修bug {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        byte[] nums = new byte[n];
        for (int i = 0; i < n; i++)
            nums[i] = (byte) (s.charAt(i) - '0');
        int m = in.nextInt();
        byte[][][] tools = new byte[m][2][n];
        for (int i = 0; i < m; i++) {
            s = in.next();
            for (int j = 0; j < n; j++)
                tools[i][0][j] = (byte) (s.charAt(j) - '0');
            s = in.next();
            for (int j = 0; j < n; j++)
                tools[i][1][j] = (byte) (s.charAt(j) - '0');
        }
        int t = in.nextInt();
        while (t-- > 0) {
            int i = in.nextInt() - 1;
            int ans = 0;
            for (int j = 0; j < n; j++) {
                if (tools[i][1][j] == 1) {
                    nums[j] = 1;
                } else if (tools[i][1][j] == 0 && tools[i][0][j] == 1) {
                    nums[j] = 0;
                }
                if (nums[j] == 1) ans++;
            }
            System.out.println(ans);
        }
    }
}

