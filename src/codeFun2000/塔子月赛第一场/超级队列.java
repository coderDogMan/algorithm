package codeFun2000.塔子月赛第一场;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 超级队列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = in.nextInt();
        while (n-- > 0) {
            int op = in.nextInt();
            if (op == 1) {
                int x = in.nextInt();
                list.add(0, x);
            } else if (op == 2) {
                int x = in.nextInt();
                list.add(x);
            } else if (op == 3) {
                Collections.sort(list);
            } else {
                int l = in.nextInt() - 1;
                int r = in.nextInt() - 1;
                long ans = 0;
                for (int i = l; i <= r; i++) {
                    ans += list.get(i);
                }
                System.out.println(ans);
            }
        }


    }
}
