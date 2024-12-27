package week.week341;

public class T2 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 0; i < divisors.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ( nums[j] % divisors[i]  == 0) {
                    sum++;
                }
            }
            if (sum > num) {
                ans = divisors[i];
                num = sum;
            } else if (sum == num) {
                ans = Math.min(ans, divisors[i]);
            }
        }
        return ans;
    }
}

class Test {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.maxDivScore(new int[]{4,7,9,3,9}, new int[]{5,2,3});
    }
}