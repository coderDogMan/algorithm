package other.hard;

import java.util.Scanner;

public class 发卡片 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
//            if (n == 0) {
//                System.out.println(3);
//            } else if (n == ){
//                pow();
//            }
        }
    }
    private static long pow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) ans = ans * a;
            b >>= 1;
            a = a * a;
        }
        return ans;
    }
}
