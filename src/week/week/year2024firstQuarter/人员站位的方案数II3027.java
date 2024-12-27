package week.week.year2024firstQuarter;

import java.util.Arrays;

public class 人员站位的方案数II3027 {

    public int numberOfPairs(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int prev = Integer.MIN_VALUE;
            for (int j = i + 1; j < n; j++) {
                if ((points[i][0] <= points[j][0] && points[i][1] >= points[j][1]) && points[j][1] > prev) {
                    ans++;
                    prev = Math.max(prev, points[j][1]);
                }
            }
        }
        return ans;

    }


}
