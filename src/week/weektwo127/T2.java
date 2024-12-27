package week.weektwo127;

public class T2 {

    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] preSum = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int x = possible[i - 1] == 1 ? 1 : -1;
            preSum[i] = preSum[i - 1] + x;
            sum += x;
        }

        for (int i = 1; i < n; i++) if (preSum[i] > sum - preSum[i]) return i;
        return -1;
    }
}
