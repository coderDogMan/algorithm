package week.week.year2023;

import java.util.ArrayList;

public class 蜡烛之间的盘子2055 {
    ArrayList<Integer> candles;
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] ans = new int[queries.length];
        candles = new ArrayList<>();
        int[] plates = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                candles.add(i);
                plates[i + 1] = plates[i];
            }
            else {
                plates[i + 1] = plates[i] + 1;
            }
        }
        int idx = 0;
        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int idxL = find(l);
            int idxR = find(r + 1) - 1;
            if (idxL >= candles.size() || idxR <= 0) {
                ans[idx++] = 0;
            }
            int candleLeft = candles.get(idxL);
            int candleRight = candles.get(idxR);
            int res = plates[candleRight] - plates[candleLeft];
            ans[idx++] = res < 0 ? 0 : res;
        }
        return ans;
    }
    //找 大于等于 target
    private int find(int target) {
        int l = 0;
        int r = candles.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (candles.get(mid) >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
class Test72 {
    public static void main(String[] args) {
        蜡烛之间的盘子2055 test = new 蜡烛之间的盘子2055();
        test.platesBetweenCandles("**|**|***|", new int[][]{{2,5}, {5,9}});

    }
}
