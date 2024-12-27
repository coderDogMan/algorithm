package week.gsdc.test1;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ziPre = in.nextInt();
        int muPre = in.nextInt();
        int flag = in.nextInt();
        if (flag == 2) {
            ziPre = -ziPre;
        }
        for (int i = 1; i < n; i++) {
            int zi = in.nextInt();
            int mu = in.nextInt();
            flag = in.nextInt();
            if (flag == 2) {
                zi = -zi;
            }

            int curMu = lcm(mu, muPre);

            zi = curMu / mu * zi;
            ziPre = curMu / muPre * ziPre;


            ziPre = ziPre + zi;
            int val = gcd(Math.abs(ziPre),curMu);
            ziPre = ziPre / val;
            muPre = curMu / val;
        }
        if (ziPre == muPre) {
            System.out.println(1);
        } else {
            System.out.println(ziPre + "/" + muPre);
        }
    }

    public static int gcd(int a, int b) {
        while(b!=0)
        {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        int i = 1;
        while (a * i % b != 0)
        {
            i++;
        }
        return a * i;
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(4 % 1);
        System.out.println(T1.gcd(4, 8));
    }
}