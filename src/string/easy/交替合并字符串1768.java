package string.easy;

public class 交替合并字符串1768 {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqr"));
    }

    public static String mergeAlternately(String word1, String word2) {
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();
        String res = "";
        int len1 = char1.length;
        int len2 = char2.length;
        for (int i = 0; i < (len1 < len2 ? len1 : len2); i++) {
            res += char1[i];
            res += char2[i];
        }

        if (len1 > len2) {
            for (int i = len2; i < len1; i++)
                res += char1[i];
        } else {
            for (int i = len1; i < len2; i++)
                res += char2[i];
        }
        return res;
    }
}
