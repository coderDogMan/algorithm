package writtentest.xhs2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 购买木材 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        int idx = 0;
        int[][] nums = new int[m][2];
        while (m-- > 0) {
            String[] val = reader.readLine().split(" ");
            int l = Integer.parseInt(val[0]);
            int r = Integer.parseInt(val[1]);
            nums[idx][0] = l;
            nums[idx++][1] = r;
        }
        Arrays.sort(nums, (a, b) -> (a[0] - b[0]));
        long ans = 0;
        int len = 0;
        int l = 0;
        idx = 0;
        while (idx < nums.length) {
            while (idx < nums.length && nums[idx][1] - nums[l][0] <= k) {
                len += nums[idx][1] - nums[idx][0];
                idx++;
            }
            if (idx == nums.length) {
                ans = Math.max(ans, len);
            } else {
                int add = Math.max(0, nums[l][0] + k - nums[idx][0]);
                ans = Math.max(ans, len + add);
                len -= nums[l][1] - nums[l][0];
                l++;
            }
        }
        System.out.println(ans);
    }
}
//10 3 9
//1 2
//3 5
//6 10