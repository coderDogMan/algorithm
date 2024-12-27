package week.week.year2023;

public class 消除相邻近似相等字符2957 {
    public int removeAlmostEqualCharacters(String word) {
        char[] chars = word.toCharArray();
        int n = chars.length;
        int ans = 0;

        for (int i = 1; i < n; i++) {
            if (Math.abs(chars[i] - chars[i - 1]) <= 1) {
                ans++;
                chars[i] = '*';
            }
        }
        return ans;
    }
}
