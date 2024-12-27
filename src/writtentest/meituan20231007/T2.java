package writtentest.meituan20231007;

import java.util.PriorityQueue;
import java.util.Scanner;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> A = new PriorityQueue<>((a, b) -> (b - a));
        PriorityQueue<Integer> B = new PriorityQueue<>((a, b) -> (b - a));
        for (int i = 0; i < n; i++) A.add(in.nextInt());
        for (int i = 0; i < n; i++) B.add(in.nextInt());
        int ans = 0;
        while (!A.isEmpty() && !B.isEmpty()) {
            if (B.peek() > A.peek()) {
                B.poll();
            } else {
                B.poll();
                A.poll();
                ans++;
            }
        }
        System.out.println(ans);


    }
}
