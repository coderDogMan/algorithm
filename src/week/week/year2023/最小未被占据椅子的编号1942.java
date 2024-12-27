package week.week.year2023;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 最小未被占据椅子的编号1942 {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] newTimes = new int[n][3];
        for (int i = 0; i < n; i++) {
            newTimes[i] = new int[]{times[i][0], times[i][1], i};
        }
        Arrays.sort(newTimes, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> points = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            points.add(i);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (int i = 0; i < n; i++) {
            int curTime = newTimes[i][0];
            while (!queue.isEmpty() && queue.peek()[1] <= curTime) {
                int[] poll = queue.poll();
                points.add(poll[2]);
            }

            if (newTimes[i][2] == targetFriend) {
                return points.peek();
            }

            queue.add(new int[]{newTimes[i][0], newTimes[i][1], points.poll()});

        }

        return -1;
    }
}

class Test58 {
    public static void main(String[] args) {
        最小未被占据椅子的编号1942 test = new 最小未被占据椅子的编号1942();
        test.smallestChair(new int[][]{{33889,98676},{80071,89737},{44118,52565},{52992,84310},{78492,88209},{21695,67063},{84622,95452},{98048,98856},{98411,99433},{55333,56548},{65375,88566},{55011,62821},{48548,48656},{87396,94825},{55273,81868},{75629,91467}}, 6);
    }
}