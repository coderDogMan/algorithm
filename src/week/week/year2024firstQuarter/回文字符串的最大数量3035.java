package week.week.year2024firstQuarter;

import java.util.Arrays;

public class 回文字符串的最大数量3035 {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] cnt = new int[26];
        int sum = 0;
        int mask = 0;
        for (String word : words) {
            sum += word.length();
            for (char c : word.toCharArray()) {
                mask ^= (1 << c - 'a');
            }
        }
        sum -= Integer.bitCount(mask);
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        int ans = 0;
        for (String word : words) {
            sum -= word.length() / 2 * 2;
            if (sum < 0) break;
            ans++;
        }
        return ans;
    }
}

class Test5 {
    public static void main(String[] args) {
//        回文字符串的最大数量3035 test = new 回文字符串的最大数量3035();
//        test.maxPalindromesAfterOperations(new String[]{"cd","ef","a"});
//        test.maxPalindromesAfterOperations(new String[]{"abc","ab"});
    }
}