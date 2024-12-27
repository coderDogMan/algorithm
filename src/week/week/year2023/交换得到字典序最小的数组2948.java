package week.week.year2023;

import java.util.Arrays;

public class 交换得到字典序最小的数组2948 {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] nNums = new int[n][2];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            nNums[i][0] = nums[i];
            nNums[i][1] = i;
        }
        Arrays.sort(nNums, (a, b) -> (a[0] - b[0]));
        int l = 0;
        for (int i = 0; i < n; i++) {
            while (i + 1 < n && nNums[i + 1][0] - nNums[i][0] <= limit) i++;
            int[][] copy = Arrays.copyOfRange(nNums, l, i + 1);
            Arrays.sort(copy, (a, b) -> (a[1] - b[1]));
            int idx = 0;
            while (l <= i) {
                ans[copy[idx++][1]] = nNums[l][0];
                l++;
            }
        }
        return ans;
    }
}
class Test104 {
    public static void main(String[] args) {
        交换得到字典序最小的数组2948 test = new 交换得到字典序最小的数组2948();
        test.lexicographicallySmallestArray(new int[]{1,7,28,19,10}, 3);
//        test.lexicographicallySmallestArray(new int[]{1,5,3,9,8}, 2);
//        test.lexicographicallySmallestArray(new int[]{1,7,6,18,2,1}, 3);
    }
}
