package week.week.year2023;

public class 网格图中机器人回家的最小代价2087 {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans = 0;
        if (homePos[0] >= startPos[0]) {
            for (int i = startPos[0] + 1; i <= homePos[0]; i++) ans += rowCosts[i];
        } else {
            for (int i = startPos[0] - 1; i >= homePos[0]; i--) ans += rowCosts[i];
        }

        if (homePos[1] >= startPos[1]) {
            for (int j = startPos[1] + 1; j <= homePos[1]; j++) ans += colCosts[j];
        } else {
            for (int j = startPos[1] - 1; j >= homePos[1]; j--) ans += colCosts[j];
        }

        return ans;
    }
}
