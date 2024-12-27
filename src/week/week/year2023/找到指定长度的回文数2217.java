package week.week.year2023;

public class 找到指定长度的回文数2217 {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            int x = queries[i];
            if (intLength % 2 == 1) {
                int leftLen = intLength / 2 + 1;
                long start = pow(10, leftLen - 1);
                long leftNum = start + x - 1;
                String s = String.valueOf(leftNum);
                if (s.length() > String.valueOf(start).length()) {
                    ans[i] = -1;
                    continue;
                }
                StringBuilder sb = new StringBuilder(s.substring(0, s.length() - 1));
                sb.reverse();
                ans[i] = Long.parseLong(s + sb.toString());
            } else {
                int leftLen = intLength / 2;
                long start = pow(10, leftLen -1);
                long leftNum = start + x - 1;
                String s = String.valueOf(leftNum);
                if (s.length() > String.valueOf(start).length()) {
                    ans[i] = -1;
                    continue;
                }
                StringBuilder sb = new StringBuilder(s.substring(0, s.length()));
                sb.reverse();
                ans[i] = Long.parseLong(s + sb.toString());
            }
        }
        return ans;
    }

    private long pow(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res *= a;
            b >>= 1;
            a = a * a;
        }
        return res;
    }

}

class Test74 {
    public static void main(String[] args) {
        找到指定长度的回文数2217 test = new 找到指定长度的回文数2217();
        test.kthPalindrome(new int[]{1,2,3,4,5,90}, 3);
    }
}