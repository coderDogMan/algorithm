package week.week388;

import java.util.Arrays;

public class T3 {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] ans = new String[n];
        Arrays.fill(ans, "");
        for (int i = 0; i < n; i++) {
            String[] son = get(arr[i]);
            Arrays.sort(son, (a, b) -> {
                if (a.length() == b.length()) return a.compareTo(b);
                return a.length() - b.length();
            });
            for (int k = 0; k < son.length; k++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        if (j == n - 1) ans[i] = son[k];
                        continue;
                    };
                    if (arr[j].contains(son[k])) break;
                    if (j == n - 1) ans[i] = son[k];
                }
                if (!ans[i].equals("")) break;
            }
        }
        return ans;
    }

    private String[] get(String s) {
        int n = s.length();
        String[] res = new String[n * (n + 1) / 2];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                res[idx++] = s.substring(i, j);
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.shortestSubstrings(new String[]{"abc","bcd","abcd"});
//        t3.shortestSubstrings(new String[]{"cab","ad","bad","c"});
    }
}
