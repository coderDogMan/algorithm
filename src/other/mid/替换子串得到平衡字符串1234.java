package other.mid;

import java.util.Arrays;

public class 替换子串得到平衡字符串1234 {
    public int balancedString(String s) {
        int n = s.length() / 4;
        int[] nums = new int[4];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'Q') nums[0]++;
            else if (s.charAt(i) == 'W') nums[1]++;
            else if (s.charAt(i) == 'E') nums[2]++;
            else if (s.charAt(i) == 'R') nums[3]++;
        }
        Arrays.sort(nums);
        int res = nums[3] - nums[0] + nums[2] - nums[1];
        return res / 2;
    }

}

