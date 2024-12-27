package other.mid;

import java.util.Arrays;

public class 词典中最长的单词720 {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Trie trie = new Trie();
        String ans = "";
        for (String s : words) {
            trie.insert(s);
            if (trie.search(s) && s.length() > ans.length()) {
                ans = s;
            }
        }
        return ans;
    }
}
class Trie{
    Trie[] children;
    boolean isWord;

    public Trie() {
        this.children = new Trie[26];
    }

    public void insert(String word) {
        Trie cur = this;
        for (int i  = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null && i == word.length() - 1) {
                cur.children[c] = new Trie();
                cur.children[c].children = new Trie[26];
                return;
            } else if (cur.children[c] == null){
                return;
            }
            cur = cur.children[c];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        Trie cur = this;
        for (int i  = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                return false;
            }
            cur = cur.children[c];
        }
        return true;
    }

}

