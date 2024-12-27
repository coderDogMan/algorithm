package week.week.year2023;

import java.util.LinkedList;
import java.util.List;

public class 循环码排列1238 {

    public List<Integer> circularPermutation(int n, int start) {
        int size = 1 << n;
        int[] nums = new int[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            nums[i] = i ^ (i >> 1);
            if (nums[i] == start) {
                j = i;
            }
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = j; i < j + size; i++) {
            ans.add(nums[i % size]);
        }
        return ans;


    }




}

class Test26 {
    public static void main(String[] args) {
        循环码排列1238 test = new 循环码排列1238();
//        test.circularPermutation(1, 0);
        test.circularPermutation(2, 3);
    }
}