package week.week395;

import java.util.HashMap;

public class T4 {

    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length - 1;
        long k = ((n + 1L) * n / 2 + 1) / 2;
        int l = 1, r = n;
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(nums, mid, k)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean check(int[] nums, int up, long k) {
        HashMap<Integer, Integer> map = new HashMap();
        long cnt = 0;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
            while (map.size() > up) {
                map.merge(nums[l], -1, Integer::sum);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            cnt += i - l + 1;
            if (cnt >= k) return true;
        }
        return false;
    }

}

class Test4 {
    public static void main(String[] args) {
        System.out.println(new T4().medianOfUniquenessArray(new int[]{3, 4, 3, 4, 5}));
    }
}