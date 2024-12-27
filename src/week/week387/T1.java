package week.week387;

import java.util.ArrayList;
import java.util.LinkedList;

public class T1 {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        LinkedList<Integer> arr1 = new LinkedList<>();
        LinkedList<Integer> arr2 = new LinkedList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < n; i++) {
            if (arr1.getLast() > arr2.getLast()) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }
        for (int i = 0; i < arr1.size(); i++) {
            ans[i] = arr1.get(i);
        }
        for (int i = arr1.size(); i < n; i++) {
            ans[i] = arr2.get(i);
        }
        return ans;
    }
}
