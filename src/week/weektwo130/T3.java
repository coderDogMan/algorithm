package week.weektwo130;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: min
 * @Date:
 */
public class T3 {
    String s;
    int[] memo;
    public int minimumSubstringsInPartition(String s) {
        this.s = s;
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(n - 1);
    }

    private int dfs(int i) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int j = i; j >= 0; j--) {
            map.merge(s.charAt(j) - 'a', 1, Integer::sum);
            if (check(map)) {
                res = Math.min(res, dfs(j - 1) + 1);
            }
        }
        return memo[i] = res;
    }

    private boolean check(HashMap<Integer, Integer> map) {
        int last = -1;
        for (Integer value : map.values()) {
            if (last != -1 && value != last) return false;
            last = value;
        }
        return true;
    }
}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        System.out.println(t3.minimumSubstringsInPartition("faf"));
        System.out.println(t3.minimumSubstringsInPartition("abababaccddb"));
        System.out.println(t3.minimumSubstringsInPartition("fabccddg"));
    }
}