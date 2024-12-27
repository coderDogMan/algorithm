package array.easy;

import java.util.HashMap;
import java.util.HashSet;

public class 存在重复元素217 {
    public static void main(String[] args) {
        containsDuplicate(new int[]{1,2,3,1});
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet = new HashSet();
        for (int num : nums) {
            if (!hashSet.add(num)) {
                return true;
            }
        }
        return false;
    }

    //自己写
//    public static boolean containsDuplicate(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num,num);
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
}
