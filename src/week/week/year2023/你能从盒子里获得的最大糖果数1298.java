package week.week.year2023;

import java.util.LinkedList;

public class 你能从盒子里获得的最大糖果数1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] vis = new boolean[n];
        boolean[] has = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            if (status[box] == 1) {
                queue.add(box);
            } else {
                has[box] = true;
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            Integer boxId = queue.poll();
            ans += candies[boxId];
            for (int key : keys[boxId]) {
                if (vis[key]) continue;

                if (has[key]) {
                    queue.add(key);
                    vis[key] = true;
                }
                else status[key] = 1;
            }

            for (int box : containedBoxes[boxId]) {
                if (has[box]) continue;
                if (status[box] == 1) {
                    vis[box] = true;
                    queue.add(box);
                }
                else has[box] = true;
            }
        }
        return ans;
    }
}

class Test81 {
    public static void main(String[] args) {
        你能从盒子里获得的最大糖果数1298 test = new 你能从盒子里获得的最大糖果数1298();
        test.maxCandies(new int[]{1,0,1,0}, new int[]{7,5,4,100}, new int[][]{{}, {}, {1}, {}}, new int[][]{{1,2},{3},{},{}}, new int[]{0});
    }

}