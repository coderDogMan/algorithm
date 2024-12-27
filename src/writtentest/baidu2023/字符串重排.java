package writtentest.baidu2023;

import java.util.Scanner;

public class 字符串重排 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.nextLine();
            if (s.contains("B") && s.contains("a") && s.contains("i") && s.contains("d") && s.contains("u")) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
