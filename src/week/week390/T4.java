package week.week390;

public class T4 {
    class Node {
        Node[] son = new Node[26];
        int len = Integer.MAX_VALUE;
        int idx = -1;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Node root = new Node();
        int minL = Integer.MAX_VALUE;
        int minId = 0;
        for (int i = 0; i < wordsContainer.length; i++) {
            String s = wordsContainer[i];
            int l = s.length();
            if (l < minL) {
                minId = i;
                minL = l;
            }
            Node cur = root;
            for (int j = l - 1; j >= 0; j--) {
                int c = s.charAt(j) - 'a';
                if (cur.son[c] == null) {
                    cur.son[c] = new Node();
                    cur.son[c].idx = i;
                    cur.son[c].len = l;
                } else {
                    if (cur.son[c].len > l) {
                        cur.son[c].len = l;
                        cur.son[c].idx = i;
                    }
                }
                cur = cur.son[c - 'a'];
            }
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String s = wordsQuery[i];
            int l = s.length();
            Node cur = root;
            int j = l - 1;
            int res = minId;
            while (j >= 0 && cur.son[s.charAt(j) - 'a'] != null) {
                cur = cur.son[s.charAt(j) - 'a'];
                res = cur.idx;
                j--;
            }
            ans[i] = res;
        }
        return ans;
    }

}
