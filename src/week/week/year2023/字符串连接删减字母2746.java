package week.week.year2023;

import java.util.Arrays;

public class 字符串连接删减字母2746 {

    String[] words;
    int[][][] memo;
    public int minimizeConcatenatedLength(String[] words) {
        int n = words.length;
        this.words = words;
        memo = new int[n][26][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        String word = words[0];
        int l = word.charAt(0) - 'a';
        int r = word.charAt(word.length() - 1) - 'a';
        return dfs(1, l, r) + word.length();


    }

    private int dfs(int i, int l, int r) {
        if (i == words.length) return 0;
        if (memo[i][l][r] != -1) return memo[i][l][r];
        String s = words[i];
        int start = s.charAt(0) - 'a';
        int end = s.charAt(s.length() - 1) - 'a';
        int res = dfs(i + 1, l, end) - (r == start ? 1 : 0);
        res = dfs(i + 1, start, r) - (end == l ? 1 : 0);
        res += s.length();
        memo[i][l][r] = res;
        return res;
    }


}


class Test49 {
    public static void main(String[] args) {
        字符串连接删减字母2746 test = new 字符串连接删减字母2746();
        test.minimizeConcatenatedLength(new String[]{"c","aab"});
    }
}