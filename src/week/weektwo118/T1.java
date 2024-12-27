package week.weektwo118;

import java.util.LinkedList;
import java.util.List;

public class T1 {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(x + "")) ans.add(i);
        }
        return ans;
    }
}
