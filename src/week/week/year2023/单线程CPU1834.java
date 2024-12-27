package week.week.year2023;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 单线程CPU1834 {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] nTasks = new int[n][3];
        for (int i = 0; i < n; i++) {
            nTasks[i][0] = tasks[i][0];
            nTasks[i][1] = tasks[i][1];
            nTasks[i][2] = i;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        Arrays.sort(nTasks, (a, b) -> (a[0] - b[0]));
        int[] ans = new int[n];
        int idx = 0;
        int curTime = 1;
        int i = 0;
        while (idx < n) {
            while (i < n && nTasks[i][0] <= curTime) {
                priorityQueue.add(new int[]{nTasks[i][0], nTasks[i][1], nTasks[i++][2]});
            }
            if (priorityQueue.isEmpty()) {
                curTime = nTasks[i][0];
            } else {
                int[] poll = priorityQueue.poll();
                ans[idx++] = poll[2];
                curTime += poll[1];
            }
        }
        return ans;
    }
}

class Test48 {
    public static void main(String[] args) {
        单线程CPU1834 test = new 单线程CPU1834();
        test.getOrder(new int[][]{{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}});
    }
}