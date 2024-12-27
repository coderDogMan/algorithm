package week.week334;

import java.math.BigInteger;

public class 找出字符串的可整除数组6368 {
    public int[] divisibilityArray(String word, int m) {
        BigInteger mod = new BigInteger(m + "");
        int[] ans = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            BigInteger bigInteger = new BigInteger(word.substring(0, i + 1));
            if (bigInteger.mod(mod).intValue() == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }
}
class Test {
    public static void main(String[] args) {
        找出字符串的可整除数组6368 test = new 找出字符串的可整除数组6368();
        test.divisibilityArray("1010", 10);
        test.divisibilityArray("998244353", 3);
    }
}

