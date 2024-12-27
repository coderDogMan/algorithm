package string.mid;

public class 无重复字符的最长子串3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int start = 0;
        StringBuffer temp = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (temp.indexOf(chars[i] + "") == -1){
                temp.append(chars[i] + "");
                res = Math.max(temp.length(), res);
            }
            else {
                temp.deleteCharAt(start);
                i--;
            }
        }
        return res;
    }
}
