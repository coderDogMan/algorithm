package writtentest.elm2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class 字符串构造 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        // 0 字符  1 出现的数量
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (char c : s.toCharArray()) set1.add(c - 'a');
        if (set1.size() == 1) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a';
            int key = -1;
            for (Integer k : set1) {
                if (k != x) {
                    key = k;
                    break;
                }
            }
            set1.remove(key);
            if (key != -1) {
                sb.append((char) (key + 'a'));
                set2.add(key);
            } else {
                for (Integer k : set2) {
                    if (k != x) {
                        key = k;
                        break;
                    }
                }
                sb.append((char) (key + 'a'));
            }

        }
        System.out.println(sb.toString());
    }
}
