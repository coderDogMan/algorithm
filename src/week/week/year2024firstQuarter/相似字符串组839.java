package week.week.year2024firstQuarter;

import java.util.ArrayList;
import java.util.Arrays;

public class 相似字符串组839 {

    int[] fa;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        fa = new int[n];
        int[] size = new int[n];
        for (int i = 0;  i < n; i++) fa[i] = i;
        Arrays.fill(size, 1);
        for (int i = 0 ; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (check(strs, i, j)) {
                    int pa = find(i), pb = find(j);
                    if (pa == pb) continue;
                    fa[pb] = pa;
                    size[pa] = size[pb];
                    size[pb] = 0;
                }
            }
        }
        int ans = 0;
        for (int i : size) {
            ans += i;
        }
        return ans;
    }

    private boolean check(String[] strs, int i, int j) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int k = 0; k < strs[i].length(); k++) {
            char a = strs[i].charAt(k);
            char b = strs[j].charAt(k);
            if (a != b) list.add(new int[] {a, b});
        }
        if (list.size() == 0) return true;
        if (list.size() != 2) return false;
        return list.get(0)[0] == list.get(1)[1] && list.get(0)[1] == list.get(1)[0];
    }

    private int find(int x) {
        if (x != fa[x]) fa[x] = find(fa[x]);
        return fa[x];
    }

}

class Test16 {
    public static void main(String[] args) {
        相似字符串组839 test = new 相似字符串组839();
        test.numSimilarGroups(new String[]{"blw","bwl","wlb"});
//        test.numSimilarGroups(new String[]{"tars","rats","arts","star"});
    }
}