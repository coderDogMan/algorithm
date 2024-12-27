package writtentest.roubao.weektwo112;

import java.util.HashMap;

public class T4 {
    public static final int MOD = (int) 1e9 + 7;
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        long cur = 0;
        long ans = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
                cur += cnt[c - 'a'];
                while (map.size() > k) {
                    char key = s.charAt(l);
                    if (map.get(key) == 1) {
                        map.remove(key);
                        cur -= cnt[key - 'a'];
                    } else {
                        map.put(key, map.get(key) - 1);
                    }
                }
                ans = Math.max(ans, cur % MOD);
            }
        }
        return (int) (ans);
    }
}
