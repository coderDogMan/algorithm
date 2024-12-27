package string.easy;

public class 反转字符串II541 {
    public static void main(String[] args) {
//        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr("abcd", 3));
    }

    public static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i += 2 * k) {
            if (i + k < s.length()) {
                reverse(arr, i , i + k);
            } else {
                reverse(arr, i , s.length());
            }
        }
        return new String(arr);
    }

    public static void reverse(char[] chars, int left, int right) {
        right--;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
