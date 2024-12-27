package writtentest.meituan2023;

import java.util.ArrayList;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int p =0; p < 2; p++) {
            int m = in.nextInt();
            int n = in.nextInt();
            ArrayList<Integer> ans = new ArrayList<Integer>();

            for (int i = m; i <= n; i++) {
                int num = 0;
                int temp = i;
                while (temp > 0) {
                    int k = temp % 10;
                    num += k * k * k;
                    temp /= 10;
                }
                if (num == i) {
                    ans.add(i);
                }
            }
            if (ans.size() == 0) {
                System.out.println("no");
            } else {
                for (int j = 0; j < ans.size(); j++) {
                    System.out.print(ans.get(j) + " ");
                }
            }
        }




    }
}
