package week.week.year2024secondQuarter;

/**
 * @Author: min
 * @Date:
 */
public class T1712 {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        long[] pre = new long[n + 1];
        int mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];
        long ans = 0;
        for (int i = 1; i < n - 1 && pre[i] * 3 <= pre[n] ; i++) {
            long target = pre[i];
            // 找到大于等于target的下标
            // pre[l]  >= pre[i] + pre[i];
            int l = find(pre, i + 1,pre[i] * 2);
            if (l >= n) continue;

            int r = find2(pre, i + 1, i);
            ans += + r - l + 1;
        }
        return (int) (ans % mod);
    }

    private int find2(long[] pre,int last,  int i) {
        int n = pre.length - 1;
        int l = last, r = n;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (pre[mid] - pre[i] > pre[n] - pre[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    private int find(long[] pre, int last,long target) {
        int l = last, r = pre.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (pre[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
class Test3 {
    public static void main(String[] args) {
        T1712 test = new T1712();
        test.waysToSplit(new int[]{0,3,3});
//        test.waysToSplit(new int[]{1,2,2,2,5,0});
//        test.waysToSplit(new int[]{1,1,1});
    }
}
