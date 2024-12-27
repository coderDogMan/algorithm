package array.mid;

public class 删除有序数组中的重复项II80 {
    public static void main(String[] args) {
//        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
//        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }

    public static int removeDuplicates(int[] nums) {
        int j = 0;
        int temp = 0;
        for (int i = 0; i < nums.length;) {
            if (temp < 2) {
                nums[j] = nums[i];
                i++;
                j++;
            } else if (nums[i] == nums[j - 1] && temp >= 2) {
                i++;
                temp++;
                continue;
            } else if (nums[i] != nums[j - 1]) {
                nums[j] = nums[i];
                j++;
                temp = 1;
            }

        }

        return j - 1;
    }
}
