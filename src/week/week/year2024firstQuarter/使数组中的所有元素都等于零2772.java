package week.week.year2024firstQuarter;

public class 使数组中的所有元素都等于零2772 {

    public boolean checkArray(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += sum[i];
            int x = nums[i];
            x -= sumD;
            if (x == 0) continue;
            if (x < 0) return false;
            sum[x + k] += x;
        }
        return true;
    }

}
