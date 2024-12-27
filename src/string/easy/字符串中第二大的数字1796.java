package string.easy;

public class 字符串中第二大的数字1796 {
    public static void main(String[] args) {

    }

    public static int secondHighest(String s) {
        int max = Integer.MIN_VALUE;
        int maxsecond = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            int num = aChar - '0';
            if (num >= 0 && num < 10 && num > max) {
                maxsecond = max;
                max = num;
            } else if ((num >= 0 && num < 10 && num == max)) {
                continue;
            } else if (num >= 0 && num < 10 && num > maxsecond) {
                maxsecond = num;
            }
        }
        return (maxsecond == Integer.MIN_VALUE || maxsecond == max) ? -1 : maxsecond;
    }
}
