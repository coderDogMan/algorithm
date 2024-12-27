package week.week402;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: min
 * @Date:
 */
public class T3 {

    public long maximumTotalDamage(int[] power) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : power) map.merge(i, 1, Integer::sum);
        int[] keys = new int[map.size()];
        int i = 0;
        for (Integer key : map.keySet()) {
            keys[i++] = key;
        }
        long[] memo = new long[map.size()];
        Arrays.fill(memo, -1);
        return dfs(0, keys, map, memo);
    }

    private long dfs(int i, int[] keys, HashMap<Integer, Integer> map, long[] memo) {
        if (i >= keys.length) return 0;
        if (memo[i] != -1) return memo[i];
        long res = dfs(i + 1, keys, map, memo);
        int j = i;
        while (j < keys.length && keys[j] - keys[i] <= 2) j++;
        res = Math.max(res, keys[i] * map.get(keys[i]) * 1L + dfs(j, keys, map, memo));
        return memo[i] = res;
    }


}
