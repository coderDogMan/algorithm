package week.week.year2023;

public class 小于等于K的最长二进制子序列2311 {

    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int m = 32 - Integer.numberOfLeadingZeros(k);
        if (m > n) return n;
        int ans = Integer.parseInt(s.substring(n - m), 2) <= k ? m : m - 1;
        for (int i = 0; i < n - m; i++) {
            ans += s.charAt(i) == '0' ? 1 : 0;
        }
        return ans;
    }
}

class Test99 {
    public static void main(String[] args) {
        小于等于K的最长二进制子序列2311 test = new 小于等于K的最长二进制子序列2311();
        test.longestSubsequence("1001010", 5);
    }
}
