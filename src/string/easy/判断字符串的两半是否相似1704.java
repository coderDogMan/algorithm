package string.easy;

public class 判断字符串的两半是否相似1704 {
    public static void main(String[] args) {
        halvesAreAlike("textbook");
    }

    public static boolean halvesAreAlike(String s) {
        String yuan = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int n = chars.length;
        int sum = 0;
        for (int i = 0; i < n / 2; i++)
            if (yuan.indexOf(chars[i]) >= 0) sum++;
        for (int i = n / 2; i < n; i++)
            if (yuan.indexOf(chars[i]) >= 0) sum--;
        return sum == 0;
    }
}
