package week.week396;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author: min
 * @Date:
 */
public class T4 {

    int MOD = (int) 1e9 + 7;
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        int max = 0;
        long sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        long up = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (max - num != 0) {
                up += max - num;
                list.add(max - num);
            }
        }
        if (cost1 * 2 <= cost2) return (int) (((up % MOD) * cost1) % MOD);
        Collections.sort(list);
        long[] pre = new long[list.size() + 1];
        for (int i = 0; i < list.size(); i++) pre[i + 1] = pre[i] + list.get(i);
        int half = find(pre) - 1;
        long one = Math.abs(pre[list.size()] - 2 * pre[half]) % MOD;
        long two = Math.min(pre[list.size()] - pre[half], pre[half]) % MOD;
        return (int) ((one * cost1 % MOD + two * cost2 % MOD) % MOD);

    }

    private int find(long[] pre) {
        int n = pre.length - 1;
        int l = 0, r = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (pre[n] - pre[mid] < pre[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
class test4 {
    public static void main(String[] args) {
        T4 t4 = new T4();
        t4.minCostToEqualizeArray(new int[]{1,14,14,15}, 2, 1);
//        t4.minCostToEqualizeArray(new int[]{2,3,3,3,5}, 2, 1);
    }
}
