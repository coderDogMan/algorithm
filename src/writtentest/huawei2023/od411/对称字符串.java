package writtentest.huawei2023.od411;

import java.util.Scanner;

public class 对称字符串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            long k = in.nextLong();
            System.out.println(dfs(n, k));
        }
    }

    private static String dfs(long n, long k) {
        if (n == 1) {
            return "red";
        } else {
            long half = (long) Math.pow(2, n - 2);
            if (k < half) {
                if ("red".equals(dfs(n - 1, k))) {
                    return "blue";
                } else {
                    return "red";
                }
            } else {
                return dfs(n -1, k - half);
            }
        }
    }
}

// A B C D E F G H I J K L M || N O P Q R S T U V W X Y Z