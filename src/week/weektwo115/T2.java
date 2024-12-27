package week.weektwo115;

import java.util.LinkedList;
import java.util.List;

public class T2 {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        LinkedList<String> ans1 = new LinkedList<>();
        LinkedList<String> ans2 = new LinkedList<>();
        int idx0 = 0;
        int idx1 = 0;
        while (idx0 < n && groups[idx0] != 0) idx0++;
        while (idx1 < n && groups[idx1] != 1) idx1++;
        int last = -1;
        for (int i = idx0; i < n; i++) {
            if (groups[i] != last) {
                ans1.add(words[i]);
                last = groups[i];
            }
        }
        last = -1;
        for (int i = idx1; i < n; i++) {
            if (groups[i] != last) {
                ans2.add(words[i]);
                last = groups[i];
            }
        }
        if (ans1.size() > ans2.size()) {
            return ans1;
        } else {
            return ans2;
        }
    }

}
class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.getWordsInLongestSubsequence(1, new String[]{"c"}, new int[]{0});

    }
}