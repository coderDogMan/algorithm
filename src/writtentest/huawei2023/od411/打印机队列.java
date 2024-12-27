package writtentest.huawei2023.od411;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 打印机队列 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // id num
        //先按 num倒序， 在按id升序
        PriorityQueue<int[]>[] service = new PriorityQueue[5];
        for (int i = 0; i < 5; i++) {
            service[i] = new PriorityQueue<int[]>((a, b) -> {
                if (a[1] == b[1]) return a[0] - b[0];
                else {
                    return b[1] - a[1];
                }
            });
        }
        int id = 1;
        for (int i = 0; i < n; i++) {
            String op = in.next();
            if (op.equals("IN")) {
                int idx = in.nextInt() - 1;
                int num = in.nextInt();
                service[idx].add(new int[]{id++, num});
            } else {
                int idx = in.nextInt() - 1;
                if (service[idx].isEmpty()) {
                    System.out.println("NULL");
                } else {
                    int[] poll = service[idx].poll();
                    System.out.println(poll[0]);
                }
            }
        }

    }
}
