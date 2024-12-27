package other.mid;

import java.util.PriorityQueue;

public class 搜索旋转排序数组33 {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, n = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            //前一段
            if (nums[mid] >= nums[left]) {
                //前一段前 或者后一段
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[n]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1, n = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            //在后一段
            if (nums[mid] < nums[n]) {
                if (target > nums[mid] && target <= nums[n]) {
                    left = mid + 1;
                } else {
                    right = mid + 1;
                }
            } else {
                //在前一段
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}

class Test23 {
    public static void main(String[] args) {
        搜索旋转排序数组33 test = new 搜索旋转排序数组33();
        System.out.println(test.search2(new int[]{3,1}, 1));
        System.out.println(test.search2(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
