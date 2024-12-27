package week.week377;

import java.util.Arrays;

public class T4 {
    class Node {
        Node[] son = new Node[26];
        int sid = -1;
    }

    int sid = 0;
    Node root = new Node();
    int[][] dp;
    char[] s, t;
    long[] memo;
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int m = cost.length;
        dp = new int[2 * m][2 * m];
        for (int i = 0; i < 2 * m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            dp[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int x = put(original[i]);
            int y = put(changed[i]);
            dp[x][y] = Math.min(dp[x][y], cost[i]);
        }

        for (int k = 0; k < 2 * m; k++) {
            for (int i = 0; i < 2 * m; i++) {
                for (int j = 0; j < 2 * m; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        s = source.toCharArray();
        t = target.toCharArray();
        memo = new long[s.length];
        Arrays.fill(memo, -1);
        long ans = dfs(0);

        return ans < Long.MAX_VALUE / 2 ? ans : -1;

    }

    private long dfs(int i) {
        if (i >= s.length) return 0;
        if (memo[i] != -1) return memo[i];
        long res = Long.MAX_VALUE / 2;
        if (s[i] == t[i]) {
            res = dfs(i + 1);
        }
        Node p = root, q = root;
        for (int j = i; j < s.length; j++) {
            p = p.son[s[j] - 'a'];
            q = q.son[t[j] - 'a'];
            if (q == null || p == null) {
                break;
            }
            if (p.sid < 0 || q.sid < 0) continue;
            int d = dp[p.sid][q.sid];
            if (d < Integer.MAX_VALUE / 2) {
                res = Math.min(res, dfs(j + 1) + d);
            }
        }

        return memo[i] = res;
    }


    private int put(String s) {
        Node o = root;
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (o.son[c] == null) {
                o.son[c] = new Node();
            }
            o = o.son[c];
        }
        if (o.sid < 0) {
            o.sid = sid++;
        }
        return o.sid;
    }



}

class Test{
    public static void main(String[] args) {
        T4 t4 = new T4();
        t4.minimumCost("abcd", "acbe", new String[]{"a","b","c","c","e","d"}, new String[]{"b","c","b","e","b","e"}, new int[]{2,5,5,1,2,20});

    }
}



// private long dfs(int i) {
//        if (i >= source.length()) {
//            return 0;
//        }
//        long res = Long.MAX_VALUE / 2;
//        if (source.charAt(i) == target.charAt(i)) {
//            res = dfs(i + 1); // 不修改 source[i]
//        }
//        Node p = root, q = root;
//        for (int j = i; j < source.length(); j++) {
//            p = p.son[source.charAt(j) - 'a'];
//            q = q.son[target.charAt(j) - 'a'];
//            if (p == null || q == null) {
//                break;
//            }
//            if (p.sid < 0 || q.sid < 0) {
//                continue;
//            }
//            // 修改从 i 到 j 的这一段
//            int d = dp[p.sid][q.sid];
//            if (d < Integer.MAX_VALUE / 2) {
//                res = Math.min(res, d + dfs(j + 1));
//            }
//        }
//        return res; // 记忆化
//    }