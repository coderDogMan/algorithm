package writtentest.meidi;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 最终数组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        LinkedList<Integer>[] stack = new LinkedList[4];
        for (int i = 0; i < 4; i++)
            stack[i] = new LinkedList<>();
        //stack[0] NORTH
        //stack[1] SOUTH
        //stack[2] WEST
        //stack[3] EAST

        for (int i = 0; i < n; i++) {
            String s = in.next();
            if (s.equals("NORTH")) {
                if (!stack[1].isEmpty()) {
                    stack[1].pollLast();
                } else {
                    stack[0].add(i);
                }
            } else if (s.equals("SOUTH")) {
                if (!stack[0].isEmpty()) {
                    stack[0].pollLast();
                } else {
                    stack[1].add(i);
                }
            } else if (s.equals("WEST")) {
                if (!stack[3].isEmpty()) {
                    stack[3].pollLast();
                } else {
                    stack[2].add(i);
                }
            } else if (s.equals("EAST")) {
                if (!stack[2].isEmpty()) {
                    stack[2].pollLast();
                } else {
                    stack[3].add(i);
                }
            }
        }
        // idx type
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        while (!stack[0].isEmpty()) queue.add(new int[]{stack[0].poll(), 0});
        while (!stack[1].isEmpty()) queue.add(new int[]{stack[1].poll(), 1});
        while (!stack[2].isEmpty()) queue.add(new int[]{stack[2].poll(), 2});
        while (!stack[3].isEmpty()) queue.add(new int[]{stack[3].poll(), 3});
        String[] str = new String[]{"NORTH", "SOUTH", "WEST", "EAST"};
        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            System.out.print(str[val[1]] + " ");
        }

    }
}
