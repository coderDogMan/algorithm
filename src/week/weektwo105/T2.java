package week.weektwo105;

import java.util.Arrays;
import java.util.HashSet;

public class T2 {
    HashSet<String> set;
    String s;
    int n;
    int[] dp;
    public int minExtraChar(String s, String[] dictionary) {
        n = s.length();
        set = new HashSet<>();
        this.s = s;
        for (String dit : dictionary) {
            set.add(dit);
        }
        dp = new int[n];
        Arrays.fill(dp, -1);
        return dfs(n - 1);
    }

    private int dfs(int idx) {
        if (idx < 0) return 0;
        if (dp[idx] != -1) return dp[idx];
        int max = dfs(idx - 1) + 1;
        for (int j = 0; j < idx + 1; j++) {
            if (set.contains(s.substring(j, idx + 1))) {
                max = Math.min(max,dfs(j - 1));
            }
        }
        dp[idx] = max;
        return max;
    }
}

class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.minExtraChar("leetscode"
        , new String[]{"leet","code","leetcode"});
//        t2.minExtraChar("dwmodizxvvbosxxw"
//        , new String[]{"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"});
    }
}