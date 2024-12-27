package array.mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和18 {
    public static void main(String[] args) {
//        fourSum(new int[]{2,2,2,2}, 8);
//        fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0);
//        fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
//        fourSum(new int[]{0,0,0,-1000000000,-1000000000,-1000000000,-1000000000}, -1000000000);
        fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList();
        if (nums.length < 4) return list;
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 3; k++) {
            if (k > 0 && nums[k] == nums[k - 1]) continue;
//            if (nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3] > target) break;
//            if (nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3] > target) continue;
            for(int i = k + 1; i < nums.length - 2; i++) {
                if (i > k + 1 && nums[i] == nums[i - 1]) continue;
//                if (nums[k] + nums[i] + nums[i + 1] + nums[i + 2] > target) break;
//                if (nums[k] + nums[i] + nums[i + 1] + nums[i + 2] > target) continue;
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if ( nums[k] + nums[i] + nums[left] + nums[right] == target) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[k]);item.add(nums[i]);item.add(nums[left]);item.add(nums[right]);
                        list.add(item);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;

                    } else if ((long) nums[k] + nums[i] + nums[left] + nums[right] > target) {
                        right--;
                    } else if ((long) nums[k] + nums[i] + nums[left] + nums[right] < target) {
                        left++;
                    }
                }
            }
        }
        return list;
    }
}
