package week.weektwo122;

import java.util.HashMap;

public class T3 {

    public static void main(String[] args) {
        System.out.println('a' - 'A');
    }

    public int minimumArrayLength(int[] nums) {
        int n =  nums.length;
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i]);
            map.merge(nums[i],  1, Integer::sum);
        }

        for (int i = 0; i < n; i++) {
            min = Math.min(min, nums[i] % min);
        }
        if (map.get(min) == null) return 1;
        return (map.get(min) + 1) / 2;
    }

}
