package week.week.year2023;

import java.util.LinkedList;
import java.util.List;

public class 双模幂运算2961 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new LinkedList();
        int n = variables.length;
        for (int i = 0; i < n; i++) {
            int[] nums = variables[i];
            int a = nums[0], b = nums[1], c = nums[2], m = nums[3];
            if ((pow(pow(a, b, 10), c, m)) == target) ans.add(i);
        }
        return ans;
    }

    public int pow(long a, long b, int mod) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return (int) ( res % mod);
    }
}
class Test107 {
    public static void main(String[] args) {
        双模幂运算2961 test = new 双模幂运算2961();
        test.getGoodIndices(new int[][]{{10,2,6,2},{8,10,5,7}}, 0);
    }
}
