package week.weektwo104;

import java.util.Arrays;
import java.util.Scanner;

public class T4 {
    public int sumOfPower(int[] nums) {
        final long MOD = (long) 1e9 + 7;
        Arrays.sort(nums);
        long s = nums[0];
        long ans = ((nums[0] * nums[0]) % MOD) * nums[0] % MOD;
        for (int i = 1; i < nums.length; i++) {
            long pow = ((long)nums[i] * (long)nums[i]) % MOD;
            ans = (ans + (pow * ((long)nums[i] + s)) % MOD) % MOD;
            s = (s * 2 + nums[i]) % MOD;
        }
        return (int)ans;
    }
}
class Test4 {
    public static void main(String[] args) {
        T4 test = new T4();
        test.sumOfPower(new int[]{2,1,4});
    }
}
