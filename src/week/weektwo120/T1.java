package week.weektwo120;

import java.util.LinkedList;
import java.util.List;

public class T1 {
    public int incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int r = i;
            int l = 0;
            while (r <= n) {
                LinkedList<Integer> list = new LinkedList<>();
                for (int j = 0; j < l; j++) list.add(nums[j]);
                for (int j = r; j < n; j++) list.add(nums[j]);
                int j = 1;
                boolean flag = true;
                for (; j < list.size(); j++) {
                    if (list.get(j) <= list.get(j - 1)) {
                        flag = false;
                        break;
                    }
                }
                ans += flag ? 1 : 0;
                l++;
                r++;
            }
        }
        return ans + 1;
    }

}

class Test1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.incremovableSubarrayCount(new int[]{8,7,6,6});
    }
}