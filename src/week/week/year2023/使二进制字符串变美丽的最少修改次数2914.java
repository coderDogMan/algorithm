package week.week.year2023;

public class 使二进制字符串变美丽的最少修改次数2914 {
    public int minChanges(String s) {
        int n = s.length();
        if (n % 2 == 1) return -1;
        int ans = 0;
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i + 1) != s.charAt(i)) ans++;
        }
        return ans;
    }
}
