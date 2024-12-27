package week.week.year2023;

public class 字母移位II2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] change = new int[n + 1];
        int[] point = new int[n + 1];
        for (int[] shift : shifts) {
            if (shift[2] == 1) {
                change[shift[0]]++;
                change[shift[1] + 1]--;
            } else {
                change[shift[0]]--;
                change[shift[1] + 1]++;
            }
        }
        point[0] = change[0];
        for (int i = 1; i <= n; i++) {
            point[i] = point[i - 1] + change[i];
        }
        StringBuilder sb = new StringBuilder();
        int add = 260000;
        char[] dit = new char[26];
        for (int i = 0; i < 26; i++)
            dit[i] = (char) ('a' + i);
        for (int i = 0; i < n; i++) {
            sb.append(dit[(s.charAt(i) - 'a' + add + point[i]) % 26]);
        }
        return sb.toString();
    }
}
//0 0 0
//-1 -1 0
//-1 0 1
//0 1 2 0
class test38 {
    public static void main(String[] args) {
        字母移位II2381 test = new 字母移位II2381();
        test.shiftingLetters("abc", new int[][]{{0,1,0}, {1,2,1}, {0,2,1}});
    }
}