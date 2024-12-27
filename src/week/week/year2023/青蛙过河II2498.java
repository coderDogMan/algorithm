package week.week.year2023;

public class 青蛙过河II2498 {
    public int maxJump(int[] stones) {
        int ans = stones[1] - stones[0];
        for (int i = 2; 2 < stones.length; i++) {
            ans = Math.max(ans, stones[i] - stones[i - 2]);
        }
        return ans;
    }
}
