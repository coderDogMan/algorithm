package niuke.中国石油大学北京第三届骏码杯程序设计竞赛;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        while (n-- > 0) {
            StringBuilder sb = new StringBuilder();
            String s = in.next();
            String[] strs = s.split("0");
            for (String str : strs) {
                int num = 0;
                for (char i : str.toCharArray()) {
                    num += (i - '0');
                }
                sb.append((char)(num + 'a' - 1));
            }
            System.out.println(sb.toString());
        }

    }
}
