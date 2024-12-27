package week.week.year2023;

import java.util.HashMap;

public class 模拟行走机器人874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int[] obstacle : obstacles) {
            int x = obstacle[0];
            int y = obstacle[1];
            HashMap<Integer, Integer> col = map.getOrDefault(x, new HashMap<>());
            col.put(y, 1);
            map.put(x, col);
        }
        //北 东 南 西
        int[][] ops = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int op = 0;
        int curX = 0;
        int curY = 0;
        int ans = 0;
        for (int command : commands) {
            if (command == -1) {
                op = (op + 1) % 4;
            } else if (command == -2) {
                op = (op - 1 + 4) % 4;
            } else {
                while (command-- > 0) {
                    int nx = curX + ops[op][0];
                    int ny = curY + ops[op][1];
                    if (map.get(nx) != null && map.get(nx).get(ny) != null) {
                        break;
                    }
                    curX = nx;
                    curY = ny;
                    ans = Math.max(ans, curX * curX + curY * curY);
                }
            }
        }
        return ans;
    }

}
