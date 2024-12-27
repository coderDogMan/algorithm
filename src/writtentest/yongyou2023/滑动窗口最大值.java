package writtentest.yongyou2023;

import java.io.*;
import java.util.PriorityQueue;

public class 滑动窗口最大值 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> (b - a));
        s = in.readLine().split(" ");
        int i = 0;
        for (; i < k - 1; i++) {
            minQueue.add(Integer.parseInt(s[i]));
            maxQueue.add(Integer.parseInt(s[i]));
        }
//        int[] ans = new int[n - k - 1];
        int idx = 0;
        int max = Integer.MIN_VALUE;
        for ( ;i < n; i++) {
            minQueue.add(Integer.parseInt(s[i]));
            maxQueue.add(Integer.parseInt(s[i]));
            max = Math.max(max, maxQueue.peek() - minQueue.peek());
            minQueue.remove(Integer.parseInt(s[idx]));
            maxQueue.remove(Integer.parseInt(s[idx]));
            idx++;
        }
        out.println(max);
        out.flush();
        in.close();

    }
}
