package week.sfX;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        // int[3] type 0 1 salary 1-10e9 good
        PriorityQueue<int[]> A = new PriorityQueue<int[]>((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        PriorityQueue<int[]> B = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        for (int i = 0; i < n; i++) {
            String s = in.next();
            int a = in.nextInt();
            int b = in.nextInt();
            if (s.equals("A")) {
                A.add(new int[]{a, b});
            } else {
                B.add(new int[]{a, b});
            }
        }
        long ans = 0;
        while (y-- > 0) {
            if (B.isEmpty()) {
                System.out.println(-1);
                return;
            }
            ans += B.poll()[1];
        }
        while (x-- > 0) {
            if (B.isEmpty() && A.isEmpty()) {
                System.out.println(-1);
                return;
            } else if (B.isEmpty()) {
                ans += A.poll()[1];
            } else if (A.isEmpty()) {
                ans += B.poll()[1];
            } else if (A.peek()[0] < B.peek()[0]) {
                ans += A.poll()[1];
            } else if (A.peek()[0] > B.peek()[0]) {
                ans += B.poll()[1];
            } else {
                if (A.peek()[1] > B.peek()[1]) {
                    ans += A.poll()[1];
                } else if (A.peek()[1] < B.peek()[1]) {
                    ans += B.poll()[1];
                } else {
                    ans += A.poll()[1];
                }
            }
        }
        System.out.println(ans);

    }
}
