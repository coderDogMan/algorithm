package writtentest.meituan2023;

import java.util.Scanner;

public class 塔子哥的01串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = s.length();
        int[] sum1 = new int[n + 1];
        int[] sum2 = new int[n + 1];
        long ans = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != '0') {
                sum1[i + 1] = sum1[i] + 1;
            } else {
                sum1[i + 1] = sum1[i];
            }
            if (i + 1 < s.length() && s.charAt(i + 1) != '1') {
                sum1[i + 2] = sum1[i + 1] + 1;
            } else if (i + 1 < s.length()){
                sum1[i + 2] = sum1[i + 1];
            }

            if (s.charAt(i) != '1') {
                sum2[i + 1] = sum2[i] + 1;
            } else {
                sum2[i + 1] = sum2[i];
            }

            if (i + 1 < s.length() && s.charAt(i + 1) != '0') {
                sum2[i + 2] = sum2[i + 1] + 1;
            } else if (i + 1 < s.length()){
                sum2[i + 2] = sum2[i + 1];
            }


        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff1 = sum1[j + 1] - sum1[i];
                int diff2 = sum2[j + 1] - sum2[i];
                ans += Math.min(diff1, diff2);
            }
        }
        System.out.println(ans);

    }
}
