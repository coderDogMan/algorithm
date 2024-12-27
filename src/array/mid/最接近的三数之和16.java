//package array.mid;
//
//import java.util.Arrays;
//
//public class 最接近的三数之和16 {
//    public static void main(String[] args) {
//        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
//        System.out.println(threeSumClosest(new int[]{0,0,0}, 1));
//    }
//
//    public static int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int min = Integer.MAX_VALUE;
//        int res[] = new int[3];
//        for (int i = 0; i < nums.length - 2; i++) {
//            int temp = Math.abs(target - (nums[i] + nums[i + 1] + nums[i + 2]));
//            if (temp < min) {
//                min  = temp;
//                res[0] = nums[i];
//                res[1] = nums[i + 1];
//                res[2] = nums[i + 2];
//            }
//        }
//        return res[0] + res[1] + res[2];
//    }
//}
