package array.easy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 只出现一次的数字136 {

    public static void main(String[] args) {
//        int i = singleNumber(new int[]{2,2,1});
        int i2 = singleNumber(new int[]{4,1,2,1,2});
//        System.out.println(4 ^ 1);
//        System.out.println(i2);
    }

    //位运算法
    public static int singleNumber(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = n ^ num;
        }
        return n;
    }


    //排序法
//    public static int singleNumber(int[] nums) {
//        int length = nums.length;
//        if (length == 1) {
//            return nums[0];
//        }
//        Arrays.sort(nums);
//        for (int i = 0; i < length - 1; i+=2) {
//            if (nums[i] != nums[i + 1]) {
//               return nums[i];
//            }
//            if (i ==  length - 3){
//                return nums[i + 2];
//            }
//        }
//        return -1;
//    }

    //暴力法
//    public static int singleNumber(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] == nums[j] && i != j) {
//                    break;
//                }
//                if (j == nums.length -1) return nums[i];
//            }
//        }
//        return -1;
//    }
}
