package writtentest.meituan20240309;

import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        long sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            sum += x;
            cnt = x == 0 ? cnt + 1 : cnt;
        }
        while (q-- > 0) {
            long l = in.nextInt();
            long r = in.nextInt();
            long min = sum + l * cnt;
            long max = sum + r * cnt;
            System.out.println(min + " " + max);
        }
    }

}
