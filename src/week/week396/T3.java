package week.week396;

import java.util.ArrayList;

/**
 * @Author: min
 * @Date:
 */
public class T3 {

    public int minAnagramLength(String s) {
        int n = s.length();
        int[] pre = new int[26];
        for (int i = 1; i <= n / 2; i++) {
            pre[s.charAt(i - 1) - 'a']++;
            if (n % i != 0) continue;
            if (check(s, pre, i)) {
                return i;
            }
        }
        return n;
    }

    private boolean check(String s, int[] pre, int cnt) {
        int[] cur = new int[26];
        int num = s.length() / cnt;

        for (int i = 1; i * cnt <= s.length(); i++) {
            for (int j = i * cnt + 1; j <= (i + 1) * cnt; j++) {
                cur[s.charAt(j - 1) - 'a']++;
            }
            if (!equals(pre, cur)) return false;
            cur = new int[26];
        }
        return true;
    }

    private boolean equals(int[] pre, int[] cur) {
        for (int i = 0; i < 26; i++) {
            if (pre[i] != cur[i]) return false;
        }
        return true;
    }

}
class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.minAnagramLength("aabbabab");
        t3.minAnagramLength("abba");
    }
}
