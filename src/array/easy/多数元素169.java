package array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class 多数元素169 {

    public static void main(String[] args) {
        int i = majorityElement(new int[]{1, 3, 1, 1, 4, 1, 1, 5, 1, 1, 6, 2, 2});
        System.out.println(i);
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


//    public static int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for (int num : nums) {
//            if (hashMap.containsKey(num)) {
//                hashMap.put(num,hashMap.get(num) + 1);
//            } else {
//                hashMap.put(num, 1);
//            }
//        }
//        int length = nums.length / 2;
//        Set<Integer> keys = hashMap.keySet();
//        for (Integer key : keys) {
//            if (hashMap.get(key) > length) return key;
//        }
//        return -1;
//    }
}
