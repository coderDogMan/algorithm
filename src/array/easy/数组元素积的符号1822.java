package array.easy;

public class 数组元素积的符号1822 {
    public static void main(String[] args) {

    }

    public static int arraySign(int[] nums) {
        int sum = 1;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num > 0) {
                sum *= 1;
            } else {
                sum *= -1;
            }
        }
        return sum;
    }
}
