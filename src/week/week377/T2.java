package week.week377;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class T2 {
    public static int MOD = (int) 1e9 + 7;
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> hSet = f(m, hFences);
        Set<Integer> vSet = f(n, vFences);
        int ans = -1;
        for (Integer num : hSet) {
            if (vSet.contains(num)) ans = Math.max(ans, num);
        }
        if (ans == -1) return -1;
        return (int) (1L * ans * ans % MOD);
    }

    private Set<Integer> f(int mx, int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length + 2);
        copy[nums.length] = 1;
        copy[nums.length + 1] = mx;
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(copy);
        for (int i = 0; i < copy.length; i++) {
            for (int j = i + 1; j < copy.length; j++) {
                set.add(copy[j] - copy[i]);
            }
        }
        return set;
    }
}
