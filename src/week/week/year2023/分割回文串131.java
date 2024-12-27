package week.week.year2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 分割回文串131 {

    List<List<String>> ans = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();
    String s;
    public List<List<String>> partition(String s) {
        this.s = s;
        dfs(0);

        return ans;
    }

    private void dfs(int i) {
        if (i == s.length()) {
            ans.add(new LinkedList<>(path));
        }
        for (int j = i; j < s.length(); j++) {
            if (check(i, j)) {
                path.add(s.substring(i, j + 1));
                dfs(j + 1);
                path.removeLast();
            }
        }

    }

    private boolean check(int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


}
