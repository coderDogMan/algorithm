package week.week390;

public class T1 {

    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                int[] cnt = new int[26];
                for (char c : sub.toCharArray()) {
                    cnt[c - 'a']++;
                }
                for (int k = 0; k < 26; k++) {
                    if (cnt[k] > 2) break;
                    if (k == 25) ans = Math.max(ans, sub.length());
                }
            }
        }
        return ans;
    }
}

class Test1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.maximumLengthSubstring("aaaa");
    }
}
