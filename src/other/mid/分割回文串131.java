package other.mid;

import java.util.LinkedList;
import java.util.List;

public class 分割回文串131 {
    List<List<String>> ans = new LinkedList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        dfs(s, 0);
        return ans;
    }

    public void dfs(String s, int startIdx) {
        if (startIdx == s.length()) {
            ans.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIdx; i < s.length(); i++) {
            if (!isOk(s.substring(startIdx, i + 1))) continue;
            path.add(s.substring(startIdx, i + 1));
            dfs(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isOk(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
