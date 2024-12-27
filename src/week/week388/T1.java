package week.week388;

import java.util.Arrays;

public class T1 {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int i : apple) {
            sum += i;
        }
        Arrays.sort(capacity);
        int cap = 0;
        for (int i = capacity.length - 1; i >= 0; i--) {
            cap += capacity[i];
            if (cap >= sum) {
                return capacity.length - i;
            }
        }
        return -1;

    }
}
