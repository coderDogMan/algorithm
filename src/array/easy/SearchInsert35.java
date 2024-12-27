package array.easy;

public class SearchInsert35 {

    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[0]){
                return 0;
            }
            if (target > nums[nums.length -1]){
                return nums.length;
            }
            if (target < nums[i] && target > nums[i - 1] || nums[i] == target ) {
                return i;
            }
        }
        return -1;
    }
}
