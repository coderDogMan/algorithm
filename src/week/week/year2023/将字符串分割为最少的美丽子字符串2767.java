package week.week.year2023;

import java.util.HashSet;

public class 将字符串分割为最少的美丽子字符串2767 {

    HashSet<String> set;
    String s;
    public int minimumBeautifulSubstrings(String s) {
        int n = s.length();
        this.s = s;
        set = new HashSet<>();
        int num = 1;
        for (int i = 0; i < 10; i++) {
            set.add(Integer.toBinaryString(num));
            num = num * 5;
        }
        // 长度 n - 1可以 分割最少的美丽字串
        int res = dfs(0);
        return res != Integer.MAX_VALUE ? res : -1;
    }

    private int dfs(int i) {
        if (i == s.length()) return 0;
        if (i == '0') return Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int j = i + 1; j <= s.length(); j++) {
            if (set.contains(s.substring(i, j))) {
                res = Math.min(res, dfs(j) + 1);
            }
        }
        return res;
    }
}

class Test50 {
    public static void main(String[] args) {
        将字符串分割为最少的美丽子字符串2767 test = new 将字符串分割为最少的美丽子字符串2767();
        test.minimumBeautifulSubstrings("1011");
    }
}