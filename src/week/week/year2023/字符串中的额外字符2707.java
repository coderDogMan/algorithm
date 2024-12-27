package week.week.year2023;

import java.util.Arrays;
import java.util.HashSet;

public class 字符串中的额外字符2707 {

    HashSet<String> set;
    String s;
    int[] memo;
    public int minExtraChar(String s, String[] dictionary) {
        set = new HashSet<>();
        int n = s.length();

        memo = new int[n];
        Arrays.fill(memo, -1);
        this.s = s;
        for (String str : dictionary) {
            set.add(str);
        }
        return dfs(n - 1);
    }

    private int dfs(int i) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];
        int res = dfs(i - 1) + 1;
        for (int j = 0; j < i; j++) {
            if (set.contains(s.substring(j, i))) {
                res = Math.min(res, dfs(j - 1));
            }
        }
        memo[i] = res;
        return res;
    }


}
