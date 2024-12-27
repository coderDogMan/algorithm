package array.easy;

public class 最小偶倍数2413 {
    public static void main(String[] args) {
        int i = smallestEvenMultiple(6);
    }

    public static int smallestEvenMultiple(int n) {
        return n % 2 == 0 ? n : n * 2;
    }
}
