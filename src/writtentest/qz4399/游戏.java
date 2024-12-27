package writtentest.qz4399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 游戏 {

    static int[] nums;
    static long MOD = (long) 1e18 + 7;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int l = 1;
        int r = (int) 1e5;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    private static boolean check(long k) {
        for (int i = 0; i < nums.length; i++) {
            k = (2 * k - nums[i]) % MOD;
            if (k < 0) return false;
        }
        return true;
    }
}
