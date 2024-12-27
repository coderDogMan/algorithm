package week.weektwo122;

public class T1 {

    public int minimumCost(int[] nums) {
        int n = nums.length;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return nums[0] + min1 + min2;
    }
}

class Test1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        t1.minimumCost(new int[] {5,4,3});
    }
}
