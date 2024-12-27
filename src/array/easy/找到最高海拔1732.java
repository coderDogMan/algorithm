package array.easy;

public class 找到最高海拔1732 {
    public static void main(String[] args) {

    }

    public static int largestAltitude(int[] gain) {
        int max = 0;
        int sum = 0;
        for (int i : gain) {
            sum += i;
            max = max > sum ? max : sum;
        }
        return max;
    }
}
