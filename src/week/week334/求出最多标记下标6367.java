package week.week334;

import java.util.Arrays;
import java.util.LinkedList;

public class 求出最多标记下标6367 {

    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> queue = new LinkedList<>();
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (queue.size() != 0 && queue.peek() * 2 <= nums[i]) {
                queue.poll();
                ans++;
            } else {
                queue.addLast(nums[i]);
            }
        }
        return ans * 2;
    }
//        Arrays.sort(nums);
//        max(nums, 0, nums.length);
//        return ans * 2;
//    public void max(int[] nums, int start, int end) {
//        int n = end;
//        int left = start;
//        int right = end;
//        if (right - left < 2) return;
//
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == nums[0] / 2) {
//                left = mid + 1; // 注意
//            } else if (nums[mid] < nums[n - 1] / 2) {
//                left = mid + 1;
//            } else if (nums[mid] > nums[n - 1] / 2) {
//                right = mid;
//            }
//        }
//        if (left - 1 < 0) return;
//        int min = left - 1;
//        right = n - 1;
//        while (min >= 0 && right > left - 1) {
//            if (nums[min] * 2 <= nums[right]) {
//                ans++;
//                min--;
//                right--;
//            } else {
//                min--;
//            }
//        }
//
//        if (min >= 1) {
//            max(nums, 0, min + 1);
//        }
//    }
}

//class Test {
//    public static void main(String[] args) {
//        求出最多标记下标6367 test = new 求出最多标记下标6367();
//        System.out.println(test.maxNumOfMarkedIndices(new int[]{9,2,5,4}));
//        System.out.println(test.maxNumOfMarkedIndices(new int[]{42, 83, 48, 10, 24, 55, 9, 100, 10, 17, 17, 99, 51, 32, 16, 98, 99, 31, 28, 68, 71, 14, 64, 29, 15, 40}));
//    }
//}

