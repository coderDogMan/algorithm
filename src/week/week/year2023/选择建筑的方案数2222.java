package week.week.year2023;

public class 选择建筑的方案数2222 {
    public long numberOfWays(String s) {
        int n = s.length();
        int[] zero = new int[n + 1];
        int[] one = new int[n + 1];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zero[i + 1] = zero[i] + 1;
                one[i + 1] = one[i];
            } else {
                one[i + 1] = one[i] + 1;
                zero[i + 1] = zero[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ans += (one[i] * (one[n] - one[i]));
            } else {
                ans += (zero[i] * (zero[n] - zero[i]));
            }
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
        选择建筑的方案数2222 test = new 选择建筑的方案数2222();
        test.numberOfWays("001101");
    }
}
