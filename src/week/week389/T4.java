//package week.week389;
//
//public class T4 {
//
//    int[] nums;
//    int k;
//    public long minimumMoves(int[] nums, int k, int maxChanges) {
//        int n = nums.length;
//        this.nums = nums;
//        this.k = k;
//
//        long ans = Long.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            int cur = 0;
//            int one = nums[i] == 1 ? 1 : 0;
//            if (one == k) ans = Math.min(ans, 1);
//            if (i > 0 && nums[i - 1] == 1) {
//                cur++;
//                one++;
//            }
//            if (one == k) ans = Math.min(ans, 2);
//            if (i + 1 < n && nums[i + 1] == 1) {
//                cur++;
//                one++;
//            }
//            if (k - one <= maxChanges) {
//                cur += (k - one) * 2;
//                ans = Math.min(ans, cur);
//            }
//
//            ans = Math.min(ans, dfs(i));
//        }
//
//    }
//
//    private long dfs(int i) {
//        return 0;
//    }
//}
