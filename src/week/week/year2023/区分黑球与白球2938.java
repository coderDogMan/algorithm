package week.week.year2023;

public class 区分黑球与白球2938 {
    public long minimumSteps(String s) {
        long ans = 0;
        int n = s.length();
        int l = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ans += i - l;
                l++;
            }
        }
        return ans;
    }
}
