package other.mid;

import other.easy.分发饼干455;

public class 摆动序列376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) return nums.length;
        int perv = 0;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            if (i == 1) res++;
            int num = nums[i] - nums[i - 1];
            if (num * perv < 0) res++;
            perv = num;
        }
        return res;
    }
}
