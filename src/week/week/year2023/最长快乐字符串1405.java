package week.week.year2023;

import java.util.PriorityQueue;

public class 最长快乐字符串1405 {
    public String longestDiverseString(int a, int b, int c) {
        int[][] dits = new int[][] {{0, a}, {1, b}, {2, c}};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, b1) -> (b1[1] - a1[1]));
        for (int[] dit : dits) {
            queue.add(dit);
        }
        int last1 = -1;
        int last2 = -1;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < a + b + c; i++) {
            int[] first = queue.poll();
            if (first[1] == 0) break;
            int[] second = queue.poll();
            if (last1 != first[0] || last2 != first[0]) {
                ans.append((char) ('a' + first[0]));
                first[1]--;
                last2 = last1;
                last1 = first[0];
            } else {
                if (second[1] == 0) break;
                ans.append((char) ('a' + second[0]));
                second[1]--;
                last2 = last1;
                last1 = second[0];
            }
            queue.add(first);
            queue.add(second);
        }
        return ans.toString();
    }
}

class Test73 {
    public static void main(String[] args) {
        最长快乐字符串1405 test = new 最长快乐字符串1405();
        test.longestDiverseString(1,1,7);
    }
}