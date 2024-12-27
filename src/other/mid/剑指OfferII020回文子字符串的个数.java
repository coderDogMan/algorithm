package other.mid;

public class 剑指OfferII020回文子字符串的个数 {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += getNumber(s, i, i);
            ans += getNumber(s, i, i + 1);
        }
        return ans;
    }

    public int getNumber(String s, int left, int right) {
        int ans = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                ans++;
                left--;
                right++;
            } else break;
        }
        return ans;
    }
}
class Test16 {
    public static void main(String[] args) {
        剑指OfferII020回文子字符串的个数 test = new 剑指OfferII020回文子字符串的个数();
        test.countSubstrings("fdsklf");
    }
}
