package week.week.year2024secondQuarter;

/**
 * @Author: min
 * @Date:
 */
public class T982 {

    public int countTriplets(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[1 << 16 + 1];
        for (int x : nums) {
            for (int y : nums) {
                cnt[x & y]++;
            }
        }
        int ans = 0;
        for (int x : nums) {
            for (int i = 0; i <= 1 << 16; i++) {
                if ((x & i) == 0) ans += cnt[i];
            }
        }
        return ans;
    }

}
