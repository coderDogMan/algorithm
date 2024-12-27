package array.mid;

import java.util.Arrays;

public class 只出现一次的数字137 {
    public static void main(String[] args) {
        int i = singleNumber(new int[]{2,2,3,2});
        System.out.println(i);
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                int temp = ((num >> i) & 1);
                total += temp;
            }
            if (total % 3 != 0) {
                int temp =  (1 << i);
                ans |= temp;
            }
        }
        return ans;

    }
//    public static int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length - 2; i+=3) {
//            if (nums[i] != nums[i + 1] && nums[i] != nums[i + 2]) {
//                return nums[i];
//            }
//        }
//        return nums[nums.length - 1];
//    }
}
