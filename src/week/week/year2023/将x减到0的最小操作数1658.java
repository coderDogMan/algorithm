package week.week.year2023;

public class 将x减到0的最小操作数1658 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int[] subSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            subSum[i] = subSum[i + 1] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int target = x - preSum[i];
            if (target < 0) break;
            int idx = findSubSum(subSum, target);
            if (idx < 0 || subSum[idx] != target || idx < i) continue;
            ans = Math.min(ans, i + (n - idx));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int findSubSum(int[] subSum, int target) {
        int l = 0;
        int r = subSum.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (subSum[mid] >= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
}

class Test69 {
    public static void main(String[] args) {
        将x减到0的最小操作数1658 test = new 将x减到0的最小操作数1658();
        test.minOperations(new int[]{3,2,20,1,1,3}, 10);
//        test.minOperations(new int[]{1,1,4,2,3}, 5);
    }
}