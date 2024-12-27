package writtentest.meituan20231007;


import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int ans = 0;
        for (char c : s.toCharArray()) {
            ans = Math.max(ans, (int) (c - '0'));
        }
        System.out.println(ans);


    }
}
