package niuke.tow;

import java.util.Calendar;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int year = in.nextInt();
        int month = in.nextInt();
        int data = in.nextInt();
        if (month == 2 && data == 29 && isRun(year) && !isRun(year + 18)) {
            System.out.println(-1);
        } else {
            System.out.println(year + 18 + " " + month + " " + data);
        }
    }

    public static boolean isRun(int year) {
        if (year % 100 != 0 && year % 4 == 0) {
            return true;
        } else if (year % 100 == 0 && year % 400 == 0) {
            return true;
        }
        return false;
    }
}
