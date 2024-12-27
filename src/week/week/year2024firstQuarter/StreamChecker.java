package week.week.year2024firstQuarter;

public class StreamChecker {

    class Node {
        Node[] son = new Node[26];
        boolean last;
    }

    Node root;
    StringBuilder sb = new StringBuilder();
    public StreamChecker(String[] words) {
        root = new Node();
        for (String word : words) {
            char[] chars = word.toCharArray();
            int n = chars.length;
            Node cur = root;
            for (int i = n - 1; i >= 0; i--) {
                int c = chars[i] - 'a';
                if (cur.son[c] == null) cur.son[c] = new Node();
                cur = cur.son[c];
            }
            cur.last = true;
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return check(sb);
    }

    private boolean check(StringBuilder sb) {
        Node cur = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            int c = sb.charAt(i) - 'a';
            if (cur.son[c] == null) return false;
            if (cur.son[c].last) return true;
            cur = cur.son[c];
        }
        return false;
    }
}
