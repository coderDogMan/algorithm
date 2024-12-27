package writtentest.meituan20231007;

import java.util.Scanner;

public class T3 {

    static int n;
    static String str;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        str = in.next();
        n = str.length();
        // 0 不删      1 删
        System.out.println(dfs(0, 0, ""));

    }

    private static int dfs(int i, int isDelete, String s) {
        if (i == n) {
            if (s.contains("mei")) return 1;
            return 0;
        }

        int res = 0;

        res = dfs(i + 1, 0, s + str.charAt(i));
        if (isDelete == 0) {
            res += dfs(i + 1, 1, s);
        }
        return res;
    }

}
