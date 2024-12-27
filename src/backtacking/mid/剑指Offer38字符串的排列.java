package backtacking.mid;

import java.util.ArrayList;

public class 剑指Offer38字符串的排列 {
    ArrayList<String> ans =  new ArrayList<>();
    StringBuffer path = new StringBuffer();
    boolean[] used;
    public String[] permutation(String s) {
        used = new boolean[s.length()];
        backtrack(s);
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;

    }

    public void backtrack(String s) {
        if (path.length() == s.length()) {
            ans.add(path.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (used[i]) continue;
            used[i] = true;
            path.append(s.charAt(i));
            backtrack(s);
            used[i] = false;
            path.delete(path.length() - 1, path.length());
        }
    }
}

class Test {
    public static void main(String[] args) {
        剑指Offer38字符串的排列 test = new 剑指Offer38字符串的排列();
        test.permutation("abc");
    }
}