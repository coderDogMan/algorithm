package week.weektwo122;

public class T2 {

    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int max = -1;
        for (int i = 0; i < n; i++) {
            int curMax = nums[i - 1];
            int curMin = nums[i - 1];
            while (i < n && Integer.bitCount(nums[i - 1]) == Integer.bitCount(nums[i])) {
                curMax = Math.max(nums[i], curMax);
                curMin = Math.min(nums[i], curMin);
                i++;
            }
            if (curMin > max) {
                max = curMax;
            } else {
                return false;
            }
        }
        return true;
    }

}
class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
//        t2.canSortArray(new int[]{75,34,30});
        t2.canSortArray(new int[]{8,4,2,30,15});
    }
}
