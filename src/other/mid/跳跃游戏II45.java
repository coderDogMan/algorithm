package other.mid;

public class 跳跃游戏II45 {
    public int jump(int[] nums) {
        int res = 0;
        int max = 0;
        int cur = 0;
        if(nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            int next = i + nums[i];
            max = Math.max(max, next);
            if (cur == i) {
                res++;
                cur = max;
                if (cur >= nums.length - 1) break;
            }
        }
        return res;
    }
}

