package week.week381;

import java.util.Arrays;

public class T1 {

    public int minimumPushes(String word) {
        int[] map = new int[26];
        for (char c : word.toCharArray()) {
            map[c - 'a']++;
        }
        Arrays.sort(map);
        int l = 0;
        int r = 25;
        while (l < r) {
            int t = map[l];
            map[l++] = map[r];
            map[r--] = t;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] == 0) break;
            if (i < 8) {
                ans += map[i];
            } else if (i >= 8 && i < 16) {
                ans += map[i] * 2;
            } else if (i >= 16 && i < 24){
                ans += map[i] * 3;
            } else {
                ans += map[i] * 4;
            }
        }
        return ans;
    }
}

class Test1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.minimumPushes("amrvxnhsewkoipjyuclgtdbfq");
        t1.minimumPushes("abcde");
    }
}