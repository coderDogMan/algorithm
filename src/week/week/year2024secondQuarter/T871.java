package week.week.year2024secondQuarter;

import java.util.PriorityQueue;

/**
 * @Author: min
 * @Date:
 */
public class T871 {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int curPoint = 0;
        int curFuel = startFuel;
        int i = 0;
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        while (curPoint < target) {
            if (curFuel == 0) {
                while (curFuel == 0 && !pq.isEmpty()) {
                    curFuel += pq.poll();
                    ans++;
                }
                if (pq.isEmpty() && curFuel == 0) return -1;
            }
            curPoint += curFuel;
            curFuel = 0;
            while (i < stations.length && stations[i][0] <= curPoint) pq.add(stations[i++][1]);
        }
        return ans;
    }


}

class Test1 {
    public static void main(String[] args) {
        T871 test = new T871();
//        test.minRefuelStops(1, 1, new int[][]{});
//        test.minRefuelStops(1, 100, new int[][]{{10, 100}});
        test.minRefuelStops(100, 10, new int[][]{{10,60}, {20,30}, {30,30}, {60,40}});
    }
}