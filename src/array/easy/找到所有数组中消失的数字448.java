package array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到所有数组中消失的数字448 {
    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int num : nums)
            nums[(num - 1) % n] += n;
        for(int i = 0; i < n; i++) {
            if (nums[i] <= n)
                list.add(i + 1);
        }
        return list;
    }
}
