package week.week.year2024firstQuarter;

import java.util.HashMap;

public class 出现频率最高的质数3044 {

    static int N = 1000005;
    static boolean[] nums = new boolean[N];
    static {
        for (int i = 2; i < N; i++) {
            if (nums[i] == true) continue;
            for (int j = 2; i * j < N && i * j > 0; j++) {
                nums[i * j] = true;
            }
        }
    }


    public int mostFrequentPrime(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0;
                for (int k = j; k < m; k++) {
                    cnt = cnt * 10 + mat[i][k];
                    map.merge(cnt, 1, Integer::sum);
                }
                cnt = 0;
                for (int k = j; k >= 0; k--) {
                    cnt = cnt * 10 + mat[i][k];
                    map.merge(cnt, 1, Integer::sum);

                }
                cnt = 0;
                for (int k = i; k < n; k++) {
                    cnt = cnt * 10 + mat[k][j];
                    map.merge(cnt, 1, Integer::sum);
                }
                cnt = 0;
                for (int k = i; k >= 0; k--) {
                    cnt = cnt * 10 + mat[k][j];
                    map.merge(cnt, 1, Integer::sum);
                }
                cnt = 0;
                for (int k = i, p = j; k < n && p < m; k++, p++) {
                    map.merge(cnt * 10 + mat[k][p], 1, Integer::sum);
                    cnt = cnt * 10 + mat[k][p];
                }
                cnt = 0;
                for (int k = i, p = j; k < n && p >= 0; k++, p--) {
                    map.merge(cnt * 10 + mat[k][p], 1, Integer::sum);
                    cnt = cnt * 10 + mat[k][p];
                }
                cnt = 0;
                for (int k = i, p = j; k >= 0 && p >= 0; k--, p--) {
                    map.merge(cnt * 10 + mat[k][p], 1, Integer::sum);
                    cnt = cnt * 10 + mat[k][p];
                }
                cnt = 0;
                for (int k = i, p = j; k >= 0 && p < m; k--, p++) {
                    map.merge(cnt * 10 + mat[k][p], 1, Integer::sum);
                    cnt = cnt * 10 + mat[k][p];
                }
            }
        }
        int ans = -1;
        int max = 0;
        for (Integer key : map.keySet()) {
            if (key > 10 && !nums[key] && map.get(key) >= max) {
                if (map.get(key) == max) ans = Math.max(key, ans);
                else ans = key;
                max = map.get(key);
            }
        }
        return ans;

    }

}

class Test9 {
    public static void main(String[] args) {
        出现频率最高的质数3044 test = new 出现频率最高的质数3044();
        test.mostFrequentPrime(new int[][]{{9,3,8},{4,2,5},{3,8,6}});
    }
}