package other.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class 会传递的困意 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] map = new int[n][m];
        while (in.hasNext()) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(map[i], 0);
            }
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;
            int num = in.nextInt();
            LinkedList<int[]> queue = new LinkedList<>();
            map[x][y] = -1;
            queue.add(new int[]{x, y});
            int ans = 1;
            while (num > 0) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] val = queue.poll();
                    int xx = val[0];
                    int yy = val[1];
                    if (xx - 1 >= 0 && map[xx - 1][yy] != -1) {
                        ans++;
                        map[xx - 1][yy] = -1;
                        queue.addLast(new int[]{xx - 1, yy});
                    }
                    if (xx + 1 < n && map[xx + 1][yy] != -1) {
                        ans++;
                        map[xx + 1][yy] = -1;
                        queue.addLast(new int[]{xx + 1, yy});
                    }
                    if (yy - 1 >= 0 && map[xx][yy - 1] != -1) {
                        ans++;
                        map[xx][yy - 1] = -1;
                        queue.addLast(new int[]{xx, yy - 1});
                    }
                    if (yy + 1 < m && map[xx][yy + 1] != -1) {
                        ans++;
                        map[xx][yy + 1] = -1;
                        queue.addLast(new int[]{xx, yy + 1});
                    }
                }
                num--;
            }
            System.out.println(ans);

        }


    }
}


