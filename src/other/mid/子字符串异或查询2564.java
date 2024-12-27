package other.mid;

import java.util.HashMap;

public class 子字符串异或查询2564 {
    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = queries.length;
        int m = s.length();
        int[][] ans = new int[n][2];
        HashMap<Integer, int[]> map = new HashMap<>();
        int idx = s.indexOf('0');
        map.put(0, new int[]{idx, idx});
        for (int i = 0; i < m; i++) {
            if (s.charAt(i) == '0') continue;
            for (int j = i; j < Math.min(m, i + 30); j++) {
                String sub = s.substring(i, j + 1);
                int num = Integer.parseInt(sub, 2);
                if (!map.containsKey(num)) {
                    map.put(num, new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int num = queries[i][1] ^ queries[i][0];
            if (map.containsKey(num)) {
                ans[i] = map.get(num);
            } else {
                ans[i] = new int[]{-1, - 1};
            }
        }
        return ans;
    }
}

class Test41 {
    public static void main(String[] args) {
        子字符串异或查询2564 test = new 子字符串异或查询2564();
        test.substringXorQueries("101101", new int[][]{{0,5}, {1,2}});
    }
}