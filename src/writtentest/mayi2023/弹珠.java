package writtentest.mayi2023;

import java.util.Scanner;

public class 弹珠 {
    static int n;
    static int m;
    static int ans;
    static int strati;
    static int stratj;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt() - 1;
        m = in.nextInt() - 1;
        strati = in.nextInt() - 1;
        stratj = in.nextInt() - 1;
        String op = in.next();
        if (op.equals("DR")) {
            DR(strati + 1, stratj + 1);
        } else if (op.equals("DL")) {
            DL(strati + 1, stratj - 1);
        } else if (op.equals("UR")) {
            UR(strati - 1, stratj + 1);
        } else if (op.equals("UL")) {
            UL(strati - 1, stratj - 1);
        }
        System.out.println(ans + 1);
    }

    private static void DR(int i, int j) {
        if (i == strati && j == stratj) return;
        ans++;
        if (i == n && j == m) UL(i - 1, j - 1);
        else if (i == n) UR(i - 1, j + 1);
        else if (j == m) DL(i + 1, j - 1);
        else {
            DR(i + 1, j + 1);
        }
    }

    private static void DL( int i, int j) {
        if (i == strati && j == stratj) return;
        ans++;
        if (i == n && j == 0) UR(i - 1, j + 1);
        else if (i == n) UL(i - 1, j - 1);
        else if (j == 0) DR(i + 1, j + 1);
        else DL(i + 1, j - 1);
    }

    private static void UR( int i, int j) {
        if (i == strati && j == stratj) return;
        ans++;
        if (i == 0 && j == m) DL(i + 1, j - 1);
        else if (i == 0) DR(i + 1, j + 1);
        else if (j == m) UL(i - 1, j - 1);
        else UR(i - 1, j + 1);

    }

    private static void UL( int i, int j) {
        if (i == strati && j == stratj) return;
        ans++;
        if (i == 0 && j == 0) DR(i + 1, j + 1);
        else if (i == 0) DL(i + 1, j - 1);
        else if (j == 0) UR(i - 1, j + 1);
        else UL(i - 1, j - 1);
    }

}
