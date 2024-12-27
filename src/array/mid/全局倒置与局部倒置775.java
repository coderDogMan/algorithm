package array.mid;

public class 全局倒置与局部倒置775 {
    public static void main(String[] args) {
        boolean b = isIdealPermutation(new int[]{1,0,2});

        System.out.println(b);
    }

    public static boolean isIdealPermutation(int[] nums) {
        int n = nums.length - 1;
        int min = nums[n];
        for(int i = n - 2; i >= 0; i--) {
            if (nums[i] > min) {
                return false;
            }
            min = Math.min(min, nums[i + 1]);
        }

        return true;
    }

}
