package array.easy;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class removeElement {
    public static void main(String[] args) {
        int[] nums = {4,4,0,1,0,2};
        int val = 0;
        removeElement(nums, val);
    }

    public static int removeElement(int[] nums, int val) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    //自己写未写出
//    public static int removeElement(int[] nums, int val) {
//        int count = nums.length;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == val) {
//                count--;
//                for (int j = i; j < nums.length; j++) {
//                    nums[j] = 0;
//                    if (j == nums.length - 1) {
//                        break;
//                    }
//                    nums[j] = nums[j + 1];
//                    nums[j + 1] = 0;
//                }
//                i--;
//            }
//
//        }
//        return count;
//    }

//      流拷贝失败
//    public static int[] removeElement(int[] nums, int val) {
//        IntStream stream = Arrays.stream(nums);
//        nums = stream.filter(i -> i != val).toArray().clone();
//
//        return ;
//
//    }
}
