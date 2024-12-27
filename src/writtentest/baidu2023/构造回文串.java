package writtentest.baidu2023;

import java.util.Scanner;

public class 构造回文串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = new char[]{ 'r', 'e', 'd' };
        int x = in.nextInt();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        int index = 0;
        while (x - num >= 0) {
            sb.append(chars[index % 3]);
            x -= num;
            num++;
            if (num > x) {
                num = 1;
                index++;
            }
        }


        System.out.println(sb.toString());
    }
}
