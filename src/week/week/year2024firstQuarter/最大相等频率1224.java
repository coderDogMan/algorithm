package week.week.year2024firstQuarter;

public class 最大相等频率1224 {
    public int maxEqualFreq(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[100000 + 1];
        int[] sum = new int[100000 + 1];
        int max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            cnt[x]++;
            sum[cnt[x]]++;
            max = Math.max(max, cnt[x]);
            if (sum[cnt[x] - 1] != 0) sum[cnt[x] - 1]--;
            if (max == 1) ans = i + 1;
            if (sum[max] * max == i || (max - 1) * (sum[max - 1] + 1) == i) ans = i + 1;
        }
        return ans;
    }
}

class Test33 {
    public static void main(String[] args) {
        最大相等频率1224 test = new 最大相等频率1224();
        test.maxEqualFreq(new int[]{1,2});
        test.maxEqualFreq(new int[]{1,1,1,2,2,2});
        test.maxEqualFreq(new int[]{2,2,1,1,5,3,3,5});
    }
}