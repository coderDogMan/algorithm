package week.week401;

import java.util.Arrays;

/**
 * @Author: min
 * @Date:
 */
public class T2 {

    public int valueAfterKSeconds(int n, int k) {
        int mod = (int) 1e9 + 7;
        long[] nums = new long[n];
        Arrays.fill(nums, 1);
        while (k-- > 0) {
            for (int i = 1; i < n; i++) nums[i] = (nums[i] + nums[i - 1]) % mod;
        }
        return (int) nums[n - 1];
    }
}

class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.valueAfterKSeconds(4, 5));
        System.out.println(t2.valueAfterKSeconds(5, 3));

    }
}