package week.week387;

import java.util.ArrayList;
import java.util.LinkedList;

public class T4 {

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ArrayList<Integer> nums1 = new ArrayList<>();
        ArrayList<Integer> nums2 = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        nums1.add(nums[0]);
        nums2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            if (greaterCount(nums1, nums[i]) > greaterCount(nums2, nums[i])) {
                arr1.add(nums[i]);
                insert(nums1, nums[i]);
            } else if (greaterCount(nums1, nums[i]) < greaterCount(nums2, nums[i])){
                arr2.add(nums[i]);
                insert(nums2, nums[i]);
            } else {
                if (arr1.size() > arr2.size()) {
                    arr2.add(nums[i]);
                    insert(nums2, nums[i]);
                } else {
                    arr1.add(nums[i]);
                    insert(nums1, nums[i]);
                }
            }
        }
        for (int i = 0; i < arr1.size(); i++) {
            ans[i] = arr1.get(i);
        }
        for (int i = arr1.size(); i < n; i++) {
            ans[i] = arr2.get(i - arr1.size());
        }
        return ans;
    }

    private void insert(ArrayList<Integer> nums, int val) {
        nums.add(find(nums, val), val);
    }

    private int greaterCount(ArrayList<Integer> nums, int val) {
        return nums.size() - find(nums, val);
    }

    private int find(ArrayList<Integer> nums, int val) {
        int l = 0, r = nums.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums.get(mid) > val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

class Test4 {
    public static void main(String[] args) {
        T4 t4 = new T4();
        t4.resultArray(new int[]{2,38,2});
    }
}