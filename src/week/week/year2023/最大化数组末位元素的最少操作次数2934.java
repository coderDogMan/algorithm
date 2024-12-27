package week.week.year2023;

public class 最大化数组末位元素的最少操作次数2934 {
    int n;
    int[] nums1;
    int[] nums2;
    public int minOperations(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        n = nums1.length;
        return Math.min(getMinOperations(nums1[n - 1], nums2[n - 1]), getMinOperations(nums2[n - 1], nums1[n - 1]) + 1);

    }

    private int getMinOperations(int last1, int last2) {
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums1[i] > last1 || nums2[i] > last2) {
                if (nums1[i] > last2 || nums2[i] > last1) {
                    return -1;
                }
                res++;

            }
        }
        return res;
    }

}

class Test89 {
    public static void main(String[] args) {
        最大化数组末位元素的最少操作次数2934 test = new 最大化数组末位元素的最少操作次数2934();
        test.minOperations(new int[]{1,5,4}, new int[]{2,5,3});
    }
}