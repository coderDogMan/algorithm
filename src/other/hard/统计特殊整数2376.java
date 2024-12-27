package other.hard;

import java.util.Arrays;

public class 统计特殊整数2376 {
    char[] s;
    int[][] dp;
    public int countSpecialNumbers(int n) {
        s = String.valueOf(n).toCharArray();
        n = s.length;
        dp = new int[n][1 << 10];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, true, false);

    }

    private int dfs(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][mask] != -1) return dp[i][mask];
        int res = 0;
        if (!isNum) {
            res += dfs(i + 1,mask, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int j = isNum ? 0 : 1; j <= up; j++) {
            if (((mask >> j) & 1) == 1) continue;
            res += dfs(i + 1,mask | (1 << j), isLimit && j == up, true);
        }
        if (!isLimit && isNum) dp[i][mask] = res;
        return res;
    }


//    char[] s;
//    int[][] memo;
//
//    public int countSpecialNumbers(int n) {
//        s = String.valueOf(n).toCharArray();
//        int m = s.length;
//        memo = new int[m][1 << 10];
//        for (int i = 0 ; i < m; i++) {
//            Arrays.fill(memo[i], - 1);
//        }
//        return dfs(0,0,true,false);
//    }
//
//    private int dfs(int i, int mask, boolean isLimit, boolean isNum) {
//        if (i == s.length) {
//            return isNum ? 1 : 0;
//        }
//        if (!isLimit && isNum && memo[i][mask] != -1) return memo[i][mask];
//        int ans = 0;
//        if (!isNum) {
//            ans = dfs(i + 1, mask, false, false);
//        }
//        int up = isLimit ? s[i] - '0' : 9;
//        for (int start = isNum ? 0 : 1; start <= up; start++) {
//            if (((mask >> start) & 1) == 0) {
//                ans += dfs(i + 1, mask | (1 << start), isLimit && start == up, true);
//            }
//        }
//        if (!isLimit && isNum) memo[i][mask] = ans;
//        return ans;
//    }
}

class Test5 {
    public static void main(String[] args) {
        统计特殊整数2376 test = new 统计特殊整数2376();
        System.out.println(test.countSpecialNumbers(135));
    }
}
