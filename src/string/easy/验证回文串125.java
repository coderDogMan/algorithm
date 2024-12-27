package string.easy;

public class 验证回文串125 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome("A man, a plan, a canal: Panama");
        boolean b = isPalindrome("0P");
        System.out.println(b);
        System.out.println(palindrome);

    }

    public static boolean isPalindrome(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            int num = (int)s.charAt(i);
            if (num <= 122 && num >= 97) temp += s.charAt(i);
            if (num <= 90 && num >= 65)  temp += (char)(num + 32);
            if (num <= 57 && num >= 48)  temp += (char)(num);
        }
        int left = 0;
        int right = temp.length() - 1;
        while (left < right) {
            if (temp.charAt(left) != temp.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
}
