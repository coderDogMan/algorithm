package other.hard;

public class 剑指Offer51数组中的逆序对 {
    int[] nums, temp;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        temp = new int[n];
        return mergeSort(nums, 0, n - 1);
    }
    public int mergeSort(int[] nums, int l, int r) {
        if (l >= r) return 0;
        int mid = (l + r) / 2;
        int ans = mergeSort(nums, l, mid) + mergeSort(nums, mid + 1, r);

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++)
            temp[k] = nums[k];
        for (int k = l; k <= r; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == r + 1 || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                ans += mid - i + 1;
            }
        }
        return ans;
    }

    public double[] dicesProbability(int n) {
        double[] arr = new double[]{1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        double[] pre = new double[]{1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < pre.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    temp[j + k] += pre[j] * arr[k];
                }
            }
            pre = temp;
        }
        return pre;
    }
}

class Test1 {
    public static void main(String[] args) {
        剑指Offer51数组中的逆序对 test = new 剑指Offer51数组中的逆序对();
        test.reversePairs(new int[]{7,5,6,4});
    }
}