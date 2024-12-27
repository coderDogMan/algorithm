package week.week373;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class T3 {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] ans = new int[n];
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, (a, b) -> nums[a] - nums[b]);
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && nums[ids[j]] - nums[ids[j - 1]] <= limit) j++;
            Integer[] temp = Arrays.copyOfRange(ids, i, j);
            Arrays.sort(temp);
            for (int k = 0; k < temp.length; k++)
                ans[temp[k]] = nums[ids[i + k]];
            i = j;
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.lexicographicallySmallestArray(new int[]{1,5,3,9,8}, 2);
//        t3.lexicographicallySmallestArray(new int[]{4,52,38,59,71,27,31,83,88,10}, 14);
    }
}