package week.week.year2024firstQuarter;

import java.util.Arrays;

public class 分发糖果135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] L = new int[n];
        int[] R = new int[n];
        Arrays.fill(L, 1);
        Arrays.fill(R, 1);
        for (int i = 1; i < n; i++) L[i] = ratings[i] > ratings[i - 1] ? L[i - 1] + 1 : 1;
        for (int i = n - 2; i >= 0; i++) R[i] = ratings[i] > ratings[i + 1] ? R[i + 1] + 1 : 1;
        int ans = 0;
        for (int i = 0; i < n; i++) ans += Math.max(L[i], R[i]);
        return ans;
    }
}

class Test17 {
    public static void main(String[] args) {
        分发糖果135 test = new 分发糖果135();
        test.candy(new int[]{1,0,1,0,0,2,22});
        test.candy(new int[]{1,0,2});
    }
}
