package week.week.year2024firstQuarter;

import java.util.ArrayList;
import java.util.Arrays;

public class 找两个和为目标值且不重叠的子数组1477 {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int cur = 0;
        int l = 0;
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cur += arr[i];
            while (cur > target) {
                cur -= arr[l++];
            }
            if (cur == target) {
                list.add(new int[] {l, i});
            }
        }
        int idx = list.size() - 1;
        int[] prefix = new int[100001];
        Arrays.fill(prefix, Integer.MAX_VALUE / 2);
        for (int i = prefix.length - 1; i >= 0; i--) {
            if (i == list.get(idx)[0]) {
                prefix[i] = Math.min(Math.min(prefix[i + 1], prefix[i]), list.get(idx)[1] - list.get(idx)[0] + 1);
                idx--;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            ans = Math.min(ans, list.get(i)[1] - list.get(i)[0] + 1 + prefix[list.get(i)[1] + 1]);
        }
        return ans > Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}

class Test20 {
    public static void main(String[] args) {
        找两个和为目标值且不重叠的子数组1477 test = new 找两个和为目标值且不重叠的子数组1477();
        test.minSumOfLengths(new int[]{3,2,2,4,3}, 3);
    }
}