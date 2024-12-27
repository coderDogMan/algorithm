package array.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class 存在重复元素219 {

    public static void main(String[] args) {
        boolean b = containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);
        System.out.println();
    }

    //滑动窗口法
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > k){
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    //hash表法
//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        int i;
//        int j;
//        for (i = 0; i < nums.length; i++) {
//            if (!hashMap.containsKey(nums[i])) hashMap.put(nums[i], i);
//            else {
//                j = hashMap.get(nums[i]);
//                if (i - j <= k)
//                    return true;
//                else {
//                    hashMap.put(nums[i], i);
//                }
//            }
//        }
//        return false;
//    }

    //自己写
//    public static boolean containsNearbyDuplicate(int[] nums, int k) {
//        int i;
//        int j;
//        for (i = 0; i < nums.length; i++) {
//            for (j = i + 1; j < nums.length && j <= k + i; j++) {
//                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


}
