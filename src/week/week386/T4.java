package week.week386;

import java.util.HashMap;
import java.util.HashSet;

public class T4 {

    int[] nums;
    int[] changeIndices;
    int n;
    int m;
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        this.n = nums.length;
        this.m = changeIndices.length;
        this.nums = nums;
        this.changeIndices = changeIndices;

        int l = n;
        int r = m;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return l > m ? -1 : l;
    }

    private boolean check(int mid) {
        // changeIndices[i] - 1 对应 nums 的下标
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        for (int i = 0; i < mid; i++) {
            set.add(changeIndices[i] - 1);
            last.put(changeIndices[i] - 1, i);
        }
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) return false;
        }
        int cnt = 0;
        for (int i = 0; i < mid; i++) {
            if (last.get(changeIndices[i] - 1) == i) {
                if (cnt < nums[changeIndices[i] - 1]) return false;
                cnt -= nums[changeIndices[i] - 1];
            } else {
                cnt++;
            }
        }
        return true;
    }

}
