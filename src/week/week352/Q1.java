package week.week352;

public class Q1 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= threshold && nums[i] % 2 == 0) {
                ans = Math.max(ans, 1);
                for (int j = i + 1; j < n && ((nums[j - 1] + nums[j]) % 2 == 1) && nums[j] <= threshold; j++) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}

class Test1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        q1.longestAlternatingSubarray(new int[]{3,2,5,4}, 5);
//        q1.longestAlternatingSubarray(new int[]{1,2}, 2);
    }
}
