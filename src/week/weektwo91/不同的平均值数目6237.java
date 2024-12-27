package week.weektwo91;

import java.util.Arrays;
import java.util.HashSet;

public class 不同的平均值数目6237 {
    public static void main(String[] args) {
        int i = distinctAverages(new int[]{9,5,7,8,7,9,8,2,0,7});
        System.out.println(i);
    }

    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        HashSet<Double> res =  new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            res.add((nums[i] + nums[n - i - 1]) / 2.0);
        }
        return res.size();
    }
}
