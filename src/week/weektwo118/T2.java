package week.weektwo118;

import java.util.Arrays;

public class T2 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        if (hBars.length == 0 || vBars.length == 0) return 1;
        int cnt1 = 1;
        int cnt2 = 1;
        int cur1 = 1;
        int cur2 = 1;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] - 1 == hBars[i - 1]) {
                cur1++;
            } else {
                cur1 = 1;
            }
            cnt1 = Math.max(cnt1, cur1);
        }

        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] - 1 == vBars[i - 1]) {
                cur2++;
            } else {
                cur2 = 1;
            }
            cnt2 = Math.max(cnt2, cur2);
        }
        int min = Math.min(cnt1, cnt2) + 1;
        return min * min;
    }
}

class Test2 {
    public static void main(String[] args) {

    }
}