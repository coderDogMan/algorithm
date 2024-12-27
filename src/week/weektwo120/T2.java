package week.weektwo120;



import java.util.Arrays;

public class T2 {

    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        int last = n - 1;
        while (last >= 0 && sum - nums[last] <= nums[last]) {
            sum -= nums[last];
            last--;
        }
        if (last < 2) return -1;
        return sum;
    }

}

class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.largestPerimeter(new int[]{1,12,1,2,5,50,3});
    }
}