package array.easy;

public class 移动零283 {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {
        int[] arr = new int[nums.length];
        int arrIndex = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != 0) {
                arr[arrIndex] = nums[i];
                arrIndex++;
            }

        for (int i = 0; i < nums.length; i++) {
            if (i <= arrIndex) {
                nums[i] = arr[i];
                continue;
            }
            nums[i] = 0;
        }
        return ;
    }
}
