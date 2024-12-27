package other.easy;

import java.util.LinkedList;

public class LCP72补给马车 {
    public int[] supplyWagon(int[] supplies) {
        int n = supplies.length;
        int num = (n + 1) / 2;
        while (num-- > 0) {
            int idx = 0;
            int max = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                if (supplies[i] + supplies[i + 1] < max) {
                    max = supplies[i] + supplies[i + 1];
                    idx = i;
                }
            }
            int val = supplies[idx] + supplies[idx + 1];;
            supplies[idx] = val;
            for (int i = idx + 1; i < n - 1; i++) {
                supplies[i] = supplies[i + 1];
            }
            n--;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = supplies[i];
        return ans;
    }
}

class Test7 {
    public static void main(String[] args) {
        LCP72补给马车 test = new LCP72补给马车();
        test.supplyWagon(new int[]{1,3,1,5});
    }
}
