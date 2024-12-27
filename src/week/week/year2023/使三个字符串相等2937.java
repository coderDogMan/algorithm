package week.week.year2023;

public class 使三个字符串相等2937 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int n = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int i = 0;
        while (i < n) {
            if (s1.charAt(i) != s2.charAt(i) || s2.charAt(i) != s3.charAt(i)) break;
            i++;
        }
        if (i == 0) return -1;
        return s1.length() + s2.length() + s3.length() - 3 * i;
    }
}
