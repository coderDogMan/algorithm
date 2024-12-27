package week.weektwo115;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T3 {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(groups[i])) map.put(groups[i], i);
        }
        LinkedList<String> ans = new LinkedList<>();
        for (Integer key : map.keySet()) {
            int idx = map.get(key);
            int last = -1;
            LinkedList<String> list = new LinkedList<>();
            for (int i = idx; i < n; i++) {
                if (last == -1) {
                    list.add(words[i]);
                    last = i;
                } else if (groups[i] != groups[last] && words[i].length() == words[last].length() && check(words[i], words[last])) {
                    list.add(words[i]);
                    last = i;
                }
            }
            if (list.size() > ans.size()) {
                ans = list;
            }
        }
        return ans;
    }

    private boolean check(String word1, String word2) {
        int res = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) res++;
        }
        return res == 1;
    }
}
class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.getWordsInLongestSubsequence(2,
                new String[]{"baa","ada"}, new int[]{1,2});
    }
}