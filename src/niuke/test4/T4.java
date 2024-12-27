package niuke.test4;

import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Trie trie = new Trie();
        int n = in.nextInt();
        int m = in.nextInt();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            trie.insert(s);
        }
        for (int i = 0; i < m; i++) {
            String s = in.next();
            int ans = trie.search(s);
            if (ans != 0) {
                System.out.println(ans);
            } else {
                trie.insert(s);
            }
        }
    }
}

class Trie {
    Trie[] children;
    int num;

    public Trie() {
        this.children = new Trie[26];
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i  = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new Trie();
                cur.children[c].children = new Trie[26];
            }
            cur.num++;
            cur = cur.children[c];
        }
        cur.num++;
    }

    public int search(String word) {
        Trie cur = this;
        for (int i  = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                return 0;
            }
            cur = cur.children[c];
        }
        return cur.num;
    }

    public int startsWith(String prefix) {
        Trie cur = this;
        for (int i  = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (cur.children[c] == null) {
                return 0;
            }
            cur = cur.children[c];
        }
        return cur.num;
    }
}
