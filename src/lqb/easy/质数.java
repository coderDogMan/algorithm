package lqb.easy;

import java.util.ArrayList;
import java.util.Scanner;

public class 质数 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int MAX = 100000;
        boolean[] used = new boolean[MAX + 2];
        int idx = 1;
        for (int i = 2; i < MAX; i++) {
            if (!used[i]) {
                list.add(i);
                for (int j = i * i; j <= MAX; j += i) {
                    used[j] = true;
                }
            }
            if (list.size() >= n) break;
        }
        System.out.println(list.get(list.size() - 1));

    }
}
