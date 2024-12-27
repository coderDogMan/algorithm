package writtentest.pdd2023;

import java.util.Scanner;

public class 回文修改 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.next();
            int n = s.length();
            int k = in.nextInt();
            int diff = 0;
            for (int i = 0; i < n / 2; i++) {
                if (s.charAt(i) != s.charAt(n - i - 1)) diff++;
            }
            if (diff == 0 && k == 1) {
                System.out.println("No");
            } else if(diff <= k){
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
