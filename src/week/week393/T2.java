package week.week393;

public class T2 {

    static int N = (int) 1e5 * 3 + 5;
    static boolean[] ok = new boolean[N];
    static {
        for (int i = 2; i < N; i++) {
            if (ok[i] == true) continue;
            for (int j = 2; i * j < N && i * j > 0; j++) {
                ok[i * j] = true;
            }
        }
    }

    public int maximumPrimeDifference(int[] nums) {
        int l = 0;
        while (ok[nums[l]]) l++;
        int r = nums.length - 1;
        while (ok[nums[r]]) r++;
        return r - l + 1;
    }

}
