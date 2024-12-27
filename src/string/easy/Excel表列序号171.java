package string.easy;

public class Excel表列序号171 {
    public static void main(String[] args) {
        int a = titleToNumber("ZY");
        System.out.println(a);
    }

    public static int titleToNumber(String columnTitle) {
        int sum = 0;
        char[] chars = columnTitle.toCharArray();
        int length = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            int a = chars[i] - 64;
            sum += a;
            if (length > 0){
                sum *= 26;
                --length;
            }
        }
        return sum;
    }
}
