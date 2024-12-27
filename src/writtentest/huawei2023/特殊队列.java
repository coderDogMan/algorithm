package writtentest.huawei2023;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 特殊队列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean isSort = true;
        int ans = 0;
        in.nextLine();
        int num = 0;
        for (int i = 0; i < 2 * n; i++) {
            String s = in.nextLine();
            if (s.equals("remove")) {
                if (!isSort) ans++;
                isSort = true;
                num--;
            } else {
                String[] split = s.split(" ");
                if (split[0].equals("tail")) {
                    num++;
                } else {
                    if (num > 0) isSort = false;
                    num++;
                }
            }
        }
        System.out.println(ans);
    }
}
//5
//head add 1
//remove
//tail add 2
//head add 3
//tail add 5
//head add 4
//remove
//remove
//remove
//remove