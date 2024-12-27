package week.week379;

public class T1 {

    public int areaOfMaxDiagonal(int[][] dimensions) {

        int len = 0;
        int ans = 0;
        for (int[] d : dimensions) {
            if (d[0] * d[0] + d[1] * d[1] > len) {
                len = d[0] * d[0] + d[1] * d[1];
                ans = d[0] * d[1];
            } else if (d[0] * d[0] + d[1] * d[1] == len) {
                ans = Math.max(ans, d[0] * d[1]);
            }
        }
        return ans;

    }

}
