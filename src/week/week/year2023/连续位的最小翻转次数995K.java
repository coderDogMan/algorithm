package week.week.year2023;

public class 连续位的最小翻转次数995K {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int cur = 0;
        int[] diff = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cur += diff[i];
            if ((nums[i] + cur) % 2 == 0) {
                if (i + k > n) return -1;
                ans++;
                cur++;
                diff[i + k]--;
            }
        }
        return ans;
    }
}

class Test86 {
    public static void main(String[] args) {
        连续位的最小翻转次数995K test = new 连续位的最小翻转次数995K();
        test.minKBitFlips(new int[]{0,0,0,1,0,1,1,0}, 3);
    }
}