package sort.esay;

import java.util.Arrays;

public class 数组拆分561 {
    public static void main(String[] args) {
        int i = arrayPairSum(new int[]{6,2,6,5,1,2});
        System.out.println(i);
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += Math.min(nums[i], nums[i + 1]);
        }

        return sum;
    }
}
