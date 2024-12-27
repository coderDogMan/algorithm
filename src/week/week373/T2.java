package week.week373;

public class T2 {
    int[] Y;
    int[] F;
    public int beautifulSubstrings(String s, int k) {
        int n = s.length();
        int ans = 0;
        Y = new int[n + 1];
        F = new int[n + 1];
        int y = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i++);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') y++;
            else f++;
            Y[i + 1] = y;
            F[i + 1] = f;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] nums = getCharNum(i + 1, j + 1);
                if (nums[0] == nums[1] && nums[0] * nums[1] % k == 0) ans++;
            }
        }
        return ans;
    }

    private int[] getCharNum(int i, int j) {
        int res1 = Y[j] - Y[i - 1];
        int res2 = F[j] - F[i - 1];
        return new int[] {res1, res2};
    }
}
