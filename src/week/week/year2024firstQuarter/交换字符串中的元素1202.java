package week.week.year2024firstQuarter;

import java.util.*;

public class 交换字符串中的元素1202 {

    int[] fa;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] chars = s.toCharArray();
        int n = s.length();
        fa = new int[n];
        for (int i = 0; i < n; i++) fa[i] = i;
        for (List<Integer> pair : pairs) {
            int x = find(pair.get(0));
            int to = find(pair.get(1));
            fa[x] = to;
        }
        HashMap<Integer, ArrayList> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(find(i))) map.get(find(i)).add(i);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(find(i), list);
            }
        }
        char[] ans = new char[n];
        for (ArrayList<Integer> list : map.values()) {
            ArrayList<Integer> clone = (ArrayList<Integer>) list.clone();
            Collections.sort(clone, (a, b) -> (chars[a] - chars[b]));
            for (int i = 0; i < list.size(); i++) {
                ans[list.get(i)] = chars[clone.get(i)];
            }
        }
        return String.valueOf(ans);
    }

    private int find(Integer x) {
        if (x != fa[x]) {
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }
}
