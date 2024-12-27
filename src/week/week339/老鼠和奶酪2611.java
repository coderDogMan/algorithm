package week.week339;

import java.util.Arrays;

public class 老鼠和奶酪2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int ans = 0;
        Integer[] diff = new Integer[n];
        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i] - reward2[i];
        }
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
        }
        Arrays.sort(diff, (a, b) -> (b - a));
        for (int i = 0; i < k; i++)
            ans += diff[i];
        return ans;
    }
}
class Test {
    public static void main(String[] args) {
        老鼠和奶酪2611 test = new 老鼠和奶酪2611();
        test.miceAndCheese(new int[]{1,1,3,4}, new int[]{4,4,1,1}, 2);
    }
}
