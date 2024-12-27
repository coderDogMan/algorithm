package week.week312;

import java.util.ArrayList;
import java.util.List;

public class 找到所有好下标6190 {
    public static void main(String[] args) {
//        List<Integer> list = goodIndices(new int[]{2, 1, 1, 1, 3, 4, 1}, 2);

    }


//    public static List<Integer> goodIndices(int[] nums, int k) {
//        int[] left = new int[nums.length], right = new int[nums.length];
//        for (int i = 2; i < nums.length; i++) {
//            right[i] = nums[i - 1] > nums[i - 2] ? 0 : right[i - 1] + 1;
//        }
//        for (int i = nums.length - 3; i >= 0; i--) {
//            left[i] = nums[i + 1] > nums[i + 2] ? 0 : left[i + 1] + 1;
//        }
//        List<Integer> list = new ArrayList<>();
//        for (int i = 1; i < nums.length - 1; ++i) {
//            if (left[i] >= k - 1 && right[i] >= k - 1) {
//                list.add(i);
//            }
//        }
//        return list;
//    }

//    public static List<Integer> goodIndices(int[] nums, int k) {
//        ArrayList<Integer> list = new ArrayList<>();
//        if (2 * k > nums.length + 1) return list;
//        if (nums.length == 3) {
//           list.add(1);
//            return list;
//        }
//        boolean b = true;
//        for (int i = k; i < nums.length - k - 1; i++) {
//            for (int start = 0; start < i - 1; start++) {
//                if (nums[start] < nums[start + 1]) {
//                    b = false;
//                }
//            }
//            for (int start = i + 1; start < nums.length - k; start++) {
//                if (nums[start] > nums[start + 1]) {
//                    b = false;
//                }
//            }
//            if (b) {
//                list.add(i);
//            } else {
//                b = true;
//            }
//        }
//        return list;
//    }
}
