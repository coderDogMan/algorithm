package week.weektwo111;

public class Q2 {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] chars = new char[26];
        for (int i = 0; i < 26; i++) {
            chars[i] = (char) ('a' + i);
        }
        int n = str1.length();
        int m = str2.length();
        int j = 0;
        int i = 0;
        for (; i < m && j < n;) {
            char c1 = str1.charAt(j);
            char c2 = str2.charAt(i);
            if (c1 == c2 || chars[(c1 - 'a' + 1 + 26) % 26] == c2) {
                j++;
                i++;
            } else {
                j++;
            }
        }
        return i == m;
    }
}

class Test2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        q2.canMakeSubsequence("ab", "d");
    }
}