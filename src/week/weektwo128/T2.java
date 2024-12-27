package week.weektwo128;

import java.util.Arrays;

public class T2 {

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a, b) -> (a[0] - b[0]));
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n;) {
            int nextX = points[i][0] + w;
            ans++;
            while (i < n && points[i][0] <= nextX) i++;
        }
        return ans;
    }
}
