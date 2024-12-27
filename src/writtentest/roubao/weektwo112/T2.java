package writtentest.roubao.weektwo112;

public class T2 {

    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int[][] dit1 = new int[2][26];
        int[][] dit2 = new int[2][26];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                dit1[0][s1.charAt(i) - 'a']++;
                dit2[0][s2.charAt(i) - 'a']++;
            } else {
                dit1[1][s1.charAt(i) - 'a']++;
                dit2[1][s2.charAt(i) - 'a']++;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 26; j++) {
                if (dit1[i][j] != dit2[i][j]) {
                    return false;
                }
            }
        }
        return true;

    }



}

class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.checkStrings("abcdba", "cabdab");
    }
}