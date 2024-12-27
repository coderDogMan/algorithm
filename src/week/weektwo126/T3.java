package week.weektwo126;

import java.util.ArrayList;
import java.util.Arrays;

public class T3 {
    public String minimizeStringValue(String s) {
        int[] cnt = new int[26];
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c != '?') {
                cnt[c - 'a']++;
            }
        }

        for (char c : s.toCharArray()) {
            if (c == '?') {
                int ch = getChar(cnt);
                list.add(ch);
                cnt[ch]++;
            }
        }
        int idx = 0;
        int[] chars = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(chars);
        for (char c : s.toCharArray()) {
            if (c == '?') {
                int ch = getChar(cnt);
                sb.append((char)(chars[idx++] + 'a'));
                cnt[ch]++;
            } else {
                cnt[c - 'a']++;
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private int getChar(int[] cnt) {
        int res = 0;
        int num = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] < num) {
                num = cnt[i];
                res = i;
            }
        }
        return res;
    }
}
