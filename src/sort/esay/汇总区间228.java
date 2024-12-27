package sort.esay;

import java.util.ArrayList;
import java.util.List;

public class 汇总区间228 {
    public static void main(String[] args) {
//        List<String> strings = summaryRanges(new int[]{0,2,3,4,6,8,9});
//        List<String> strings = summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
//        List<String> strings = summaryRanges(new int[]{-1});
        List<String> strings = summaryRanges(new int[]{0,1,2,4,5,7});
        System.out.println(strings);
    }

    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        if (nums.length == 0) return list;
        if (nums.length == 1) {
            list.add(nums[0] + "");
            return list;
        }
        int start = nums[0];
        int end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
                if (i == nums.length - 1) list.add(start + "->" + end);
            } else {
                if (start != end) {
                    list.add(start + "->" + end);
                } else {
                    list.add(start + "");
                }
                if (i == nums.length - 1) list.add(nums[i] + "");
                start = nums[i];
                end = nums[i];
            }
        }
        return list;
    }
}
