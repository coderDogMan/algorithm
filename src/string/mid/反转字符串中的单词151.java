package string.mid;

public class 反转字符串中的单词151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        StringBuffer buffer = new StringBuffer(s);
        buffer.reverse();

        while (buffer.charAt(0) == ' '){
            buffer.delete(0, 1);
        }
        while (buffer.charAt(buffer.length() - 1) == ' '){
            buffer.delete(buffer.length() - 1, buffer.length());
        }
        int left = 0;
        int right = 0;
        while (right < buffer.length()) {
            if (right > 0 && buffer.charAt(right) != ' ' && buffer.charAt(right - 1) == ' ' ) {
                left = right;
            } else if (buffer.charAt(right) != ' ') {
            } else if(buffer.charAt(right) == buffer.charAt(right - 1) && buffer.charAt(right) == ' ') {
                buffer.delete(right, right + 1);
                right--;
            } else if (buffer.charAt(right) == ' ') {
                myReverse(buffer, left, right);
            }
            right++;
        }
        myReverse(buffer, left, right);
        return buffer.toString();
    }

    public static void myReverse(StringBuffer buf, int l, int r) {
        while (l < r) {
            char temp = buf.charAt(l);
            buf.replace(l, l + 1, buf.charAt(r - 1) + "");
            buf.replace(r - 1, r,temp + "");
            r--;
            l++;
        }
    }
}
