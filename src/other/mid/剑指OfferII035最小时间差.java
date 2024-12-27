package other.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 剑指OfferII035最小时间差 {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            String s = timePoints.get(i);
            ans[i] = Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(3, 5));
        }
        Arrays.sort(ans);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            res = Math.min(res, ans[i + 1] - ans[i]);
        }
        res = Math.min(res, 24 * 60 - ans[ans.length - 1] + ans[0]);
        return res;
    }
}

class Test19 {
    public static void main(String[] args) {
        剑指OfferII035最小时间差 test = new 剑指OfferII035最小时间差();
        ArrayList<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");

        test.findMinDifference(list);
    }
}