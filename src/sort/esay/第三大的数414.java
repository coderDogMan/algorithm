package sort.esay;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class 第三大的数414 {
    public static void main(String[] args) {
        int i = thirdMax(new int[]{2,2,3,1, 5, 6});
        int i2 = thirdMax(new int[]{ 1, 2});
        System.out.println();
    }

    public static int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3)
                set.remove(set.first());
        }
        return set.size() == 3 ? set.first() : set.last();
    }
//    public static int thirdMax(int[] nums) {
//        if (nums.length == 1) return nums[0];
//        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
//        if (nums.length == 3) {
//            return Math.max(Math.max(nums[0],nums[1]), nums[2]);
//        }
//        Arrays.sort(nums);
//        int i = 0;
//        int temp = -1;
//        for (int j = nums.length - 1; j > -1; j--) {
//            if (nums[j] != temp) {
//                i++;
//                temp = nums[j];
//            }
//            if (i == 3) {
//                temp = nums[j];
//                break;
//            }
//        }
//        return temp;
//    }

//    public static int thirdMax(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums)
//            set.add(num);
//
//        if (nums.length == 1) return nums[0];
//        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
//        int oneMax = 0;
//        int towMax = 0;
//        int thrMax = 0;
//        for (Integer num : set) {
//            if (num > oneMax) {
//                thrMax = towMax;
//                towMax = oneMax;
//                oneMax = num;
//            } else if (num > towMax) {
//                thrMax = towMax;
//                towMax = num;
//            } else if (num > thrMax){
//                thrMax = num;
//            }
//        }
//        return thrMax;
//    }
}
