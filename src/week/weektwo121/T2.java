package week.weektwo121;

public class T2 {

    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((xor & 1) != (k & 1)) ans++;
            xor >>= 1;
            k >>= 1;
        }
        return ans;
    }

}
