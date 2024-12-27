package week.week.year2024secondQuarter;

import java.util.Arrays;

/**
 * @Author: min
 * @Date:
 */
public class T1049 {

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = Arrays.stream(stones).sum();
        int half = sum / 2;
        int[] f = new int[half + 1];
//        f[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = half; j >= stones[i]; j--) {
                f[j] = Math.max(f[j], f[j - stones[i]] + stones[i]);
            }
        }
        return sum - f[half] * 2;
    }

}

class Test5 {
    public static void main(String[] args) {
        T1049 test = new T1049();
        test.lastStoneWeightII(new int[]{2,7,4,1,8,1});
    }
}
