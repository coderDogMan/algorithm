//package week.gsdc;
//
//import java.util.Scanner;
//
//public class TK {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//
//
//    }
//}
//
//
//public class Trie {
//    Trie[] children;
//    boolean isWord;
//
//    public Trie() {
//        this.children = new Trie[26];
//    }
//
//    public void insert(String word) {
//        Trie cur = this;
//        for (int i  = 0; i < word.length(); i++) {
//            int c = word.charAt(i) - 'a';
//            if (cur.children[c] == null) {
//                cur.children[c] = new Trie();
//                cur.children[c].children = new Trie[26];
//            }
//            cur = cur.children[c];
//        }
//        cur.isWord = true;
//    }
//
//    public boolean search(String word) {
//        Trie cur = this;
//        for (int i  = 0; i < word.length(); i++) {
//            int c = word.charAt(i) - 'a';
//            if (cur.children[c] == null) {
//                return false;
//            }
//            cur = cur.children[c];
//        }
//        return cur.isWord;
//    }
//
//    public boolean startsWith(String prefix) {
//        Trie cur = this;
//        for (int i  = 0; i < prefix.length(); i++) {
//            int c = prefix.charAt(i) - 'a';
//            if (cur.children[c] == null) {
//                return false;
//            }
//            cur = cur.children[c];
//        }
//        return true;
//    }
//}
