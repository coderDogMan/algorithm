package week.week312;

public class 按位与最大的最长子数组6189 {
    public static void main(String[] args) {
        int i1 = longestSubarray(new int[]{1,2,3,3,2,2});
        int i2 = longestSubarray(new int[]{1,2,3,4});

        System.out.println(i1);
        System.out.println(i2);

    }

    public static int longestSubarray(int[] nums) {
        int max = 1, result = 0, curr = 0;
        for (int num : nums) {
            if (num == max) {
                result = Math.max(result, ++curr);
            } else if (num > max) {
                max = num;
                result = curr = 1;
            } else {
                curr = 0;
            }
        }
        return result;
    }

//    public static int longestSubarray(int[] nums) {
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            max = max > nums[i] ? max : nums[i];
//        }
//        int count = 0;
//        int temp = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == max) {
//                temp++;
//                count = count > temp ? count : temp;
//            } else {
//                count = count > temp ? count : temp;
//                temp = 0;
//            }
//        }
//        return count;
//    }
}
