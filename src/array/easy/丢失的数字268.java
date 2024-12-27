package array.easy;

import java.util.Arrays;

public class 丢失的数字268 {
    public static void main(String[] args) {
        int i = missingNumber(new int[]{3,0,1});
        System.out.println(i);
    }

    public static int missingNumber(int[] nums) {
        int length = nums.length;
        int x = 0;
        for (int i = 0; i < length; i++)
            x ^= nums[i];

        for (int i = 0; i <= length; i++)
            x ^= i;
        return x;
    }

//    public static int missingNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != i) return i;
//        }
//        return nums[nums.length - 1] + 1;
//    }
}
