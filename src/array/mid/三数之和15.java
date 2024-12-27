package array.mid;

import java.util.*;

public class 三数之和15 {

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1,0,1,2,-1,-4});
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        if (nums == null || nums.length < 3) return list;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0 ) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(nums[i]);item.add(nums[left] );item.add(nums[right]);
                    list.add(item);
                    left++;right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target){
                    left++;
                }
            }
        }
        return list;
    }
//    public static List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> list = new ArrayList();
//        HashSet<List<Integer>> set = new HashSet<>();
//        int i1 = 0;
//        int i2 = nums.length / 3;
//        int i3 = nums.length / 3 * 2;
//
//        for (; i1 < i2; i1++) {
//            for (; i2 < i3; i2++) {
//                for (; i3 < nums.length; i3++) {
//                    if (nums[i1] + nums[i2] + nums[i3] == 0) {
//                        List<Integer> key = new ArrayList<>();
////                        List<Integer> value = new ArrayList<>();
//                        key.add(nums[i1]);
//                        key.add(nums[i2]);
//                        key.add(nums[i3]);
//                        Collections.sort(key);
//                        set.add(key);
////                        value.add(i1);
////                        value.add(i2);
////                        value.add(i3);
//                    }
//                }
//            }
//        }
//
//
//        return null;
//    }

}
