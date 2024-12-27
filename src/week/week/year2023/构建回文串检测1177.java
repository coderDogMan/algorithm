package week.week.year2023;

import java.util.LinkedList;
import java.util.List;

public class 构建回文串检测1177 {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] perSum = new int[n + 1][26];
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            perSum[i + 1][c] = perSum[i][c] + 1;
            for (int j = 0; j < 26; j++) {
                if (c == j) continue;
                perSum[i + 1][j] = perSum[i][j];
            }
        }

        List<Boolean> ans = new LinkedList<>();
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            int k = queries[i][2];
            int cur = 0;
            for (int j = 0; j < 26; j++) {
                if ((perSum[r][j] - perSum[l][j]) % 2 == 1) cur++;
            }
            ans.add(cur / 2 <= k);
        }
        return ans;
    }

}

class Test100 {
    public static void main(String[] args) {
        构建回文串检测1177 test = new 构建回文串检测1177();
        test.canMakePaliQueries("abcda", new int[][]{{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}});
    }
}
