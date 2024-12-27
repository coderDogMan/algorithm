package week.week394;

public class T2 {

    public int numberOfSpecialChars(String word) {
        int n = word.length();
        boolean[] v = new boolean[26];
        boolean[] pre = new boolean[26];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z' && !v[word.charAt(i) - 'a'] && !pre[word.charAt(i) - 'a']) {
                v[word.charAt(i) - 'a'] = true;
                while (j < n && word.charAt(j) != word.charAt(i) - 32) j++;
                if (j == n) continue;
                boolean ok = false;
                for ( ;j < n; j++) if (word.charAt(j) == word.charAt(i)) ok = true;
                if (!ok) ans++;
            }
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') pre[word.charAt(i) - 'A'] = true;
        }
        return ans;
    }
}

class Test2{
    public static void main(String[] args) {
        T2 t2 = new T2();
            t2.numberOfSpecialChars("AbcbDBdD");
//        t2.numberOfSpecialChars("b");
    }
}