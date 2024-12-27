package week.week338;

import java.util.HashSet;

public class T2 {
    private final static int MAX = 1000;
    private final static int[] primes = new int[169];

    public static void init() {
        boolean[] used = new boolean[MAX + 1];
        int index = 1;
        for (int i= 2; i <= MAX; i++) {
            if (!used[i]) {
                primes[index++] = i;
                for (int j = i; j * i <= MAX; j++) {
                    used[j * i] = true;
                }
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        init();
        int index = findLow(primes, nums[0]) - 1;
        int pre = nums[0] - primes[index];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= pre) return false;
            // x - p > pre
            // p < x - pre
            int j = findLow(primes, nums[i] - pre) - 1;
            nums[i] -= primes[j];
            pre = nums[i];
        }
        return true;
    }

    public int findLow(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}

class Test1 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        System.out.println(t2.primeSubOperation(new int[]{4, 9, 6, 10}));
//        System.out.println(t2.findLow(new int[]{1, 2, 3, 3, 3, 3, 5}, -1));
    }
}
