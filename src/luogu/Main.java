package luogu;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int v = sc.nextInt();
        int hour = 7;
        int minute = 50;
        int m = s / v;
        if (s % v != 0) m++;
        hour = hour - m / 60;
        if (hour < 0) hour = 23 + hour;
        m = m % 60;
        if (m > 50) {
            hour--;
        } else {
            minute -= m;
        }
        String h = hour > 10 ? hour + "" : "0" + hour;
        String min = minute > 10 ? minute + "" : "0" + minute;
        System.out.println(h + ":"  + min);
    }
}
