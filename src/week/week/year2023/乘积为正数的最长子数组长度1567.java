package week.week.year2023;

public class 乘积为正数的最长子数组长度1567 {
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int[] pos = new int[n];
        int[] neg = new int[n];
        if (nums[0] > 0) {
            pos[0] = 1;
            ans = 1;
        } else if (nums[0] < 0) {
            neg[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            } else if (nums[i] > 0) {
                pos[i] = pos[i - 1] + 1;
                neg[i] = neg[i - 1] == 0 ? 0 : neg[i - 1] + 1;
            } else if (nums[i] < 0) {
                pos[i] = neg[i - 1] == 0 ? 0 : neg[i - 1] + 1;
                neg[i] = pos[i - 1] + 1;
            }
            ans = Math.max(ans, pos[i]);
        }
        return ans;
    }
}
class Test8 {
    public static void main(String[] args) {
        乘积为正数的最长子数组长度1567 test = new 乘积为正数的最长子数组长度1567();
//        test.getMaxLen(new int[]{0,1,-2,-3,-4});
        test.getMaxLen(new int[]{5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2});
    }
}
