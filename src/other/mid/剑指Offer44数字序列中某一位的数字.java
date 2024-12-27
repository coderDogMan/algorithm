package other.mid;

public class 剑指Offer44数字序列中某一位的数字 {
    public int findNthDigit(int n) {
        int start = 1, dit = 1, count = 9;
        while (n > count) {
            n -= count;
            start *= 10;
            dit++;
            count = 9 * start * dit;
        }
        long num = start + (n - 1) / dit ;
        return Long.toString(num).charAt((n - 1) % dit) - '0';
    }
}

class Test6 {
    public static void main(String[] args) {
        剑指Offer44数字序列中某一位的数字 test = new 剑指Offer44数字序列中某一位的数字();
        test.findNthDigit(11);
    }
}