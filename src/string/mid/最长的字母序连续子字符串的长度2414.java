package string.mid;

public class 最长的字母序连续子字符串的长度2414 {
    public static void main(String[] args) {
        int i = longestContinuousSubstring("abcde");
        System.out.println(i);
    }

    public static int longestContinuousSubstring(String s) {
        int max = 0;
        int temp = 1;
        char[] chars = s.toCharArray();
        int length = chars.length - 1;
        for (int i = 0; i < length; i++) {
            int a = chars[i];
            int b = chars[i + 1];
            if ( a + 1 == b) {
                temp++;
            } else {
                max = max > temp ? max : temp;
                temp = 1;
            }
        }
        max = max > temp ? max : temp;
        return max;
    }
}
