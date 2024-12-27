package week.week.year2024firstQuarter;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class 进行操作使字符串为空3039 {

    public String lastNonEmptyString(String s) {

        LinkedList<Integer>[] cnt = new LinkedList[26];
        Arrays.setAll(cnt, e -> new LinkedList<>());
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a'].add(i);
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, cnt[i].size());
        }
        LinkedList<int[]> chars = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (cnt[i].size() == max) {
                chars.add(new int[]{i + 'a', cnt[i].getLast()});
            }
        }
        Collections.sort(chars, (a, b) -> (a[1] - b[1]));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.size(); i++) {
            sb.append((char) (chars.get(i)[0]));
        }
        return sb.toString();
    }

}
