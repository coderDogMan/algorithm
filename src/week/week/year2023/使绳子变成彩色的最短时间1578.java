package week.week.year2023;

import java.util.Arrays;

public class 使绳子变成彩色的最短时间1578 {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int i = 0;
        int ans = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && colors.charAt(j - 1) == colors.charAt(j)) j++;
            int[] temp = Arrays.copyOfRange(neededTime, i, j);
            Arrays.sort(temp);
            for (int k = 0; k < temp.length - 1; k--) {
                ans += temp[i];
            }
            i = j;
        }
        return ans;
    }
}
