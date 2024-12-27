package niuke.test4;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n % 2 == 1) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
