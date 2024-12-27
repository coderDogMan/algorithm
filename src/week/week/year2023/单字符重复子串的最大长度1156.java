package week.week.year2023;

public class 单字符重复子串的最大长度1156 {
    public int maxRepOpt1(String text) {
        int[] cnt = new int[26];
        char[] s = text.toCharArray();
        for (char c : s) {
            cnt[c - 'a']++;
        }
        int i = 0;
        int ans = 0;
        while (i < s.length) {
            int j = i;
            while (j < s.length && s[j] == s[i]) {
                j++;
            }

            int l = j - i;
            int k = j + 1;
            while (k < s.length && s[k] == s[i]) {
                k++;
            }
            int r = k - j - 1;
            ans = Math.max(ans, Math.min(l + r + 1, cnt[s[i]] - 'a'));
            i = j;

        }
        return ans;
    }
}

class Test34 {
    public static void main(String[] args) {
        单字符重复子串的最大长度1156 test = new 单字符重复子串的最大长度1156();
        test.maxRepOpt1("bbababaaaa");
    }
}