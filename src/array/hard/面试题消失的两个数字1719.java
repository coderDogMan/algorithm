package array.hard;


import java.util.HashMap;

public class 面试题消失的两个数字1719 {

    public static void main(String[] args) {
        int[] ints = missingTwo(new int[]{2, 3});
        System.out.println(Integer.MIN_VALUE);
    }

    public static int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int yihuosum = 0;
        for (int num : nums)
            yihuosum ^= num;
        for (int i = 1; i <= n; i++)
            yihuosum ^= i;
        int lsb =  yihuosum & (-yihuosum);
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & lsb) != 0){
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & lsb) != 0){
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }

        return new int[]{num1, num2};
    }
}
