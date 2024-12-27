package other.easy;

public class 剑指Offer17打印从1到最大的n位数 {

    char[] arr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    StringBuffer ans = new StringBuffer();
    int length = 0;
    public int[] printNumbers(int n) {
        length = n;
        backtrack(new StringBuffer(), '0');
        String[] list = ans.toString().split(",");

        int[] res = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            res[i] = Integer.parseInt(list[i]);
        }
        return res;
    }

    public void backtrack(StringBuffer n, char startIndex) {
        if (n.length() == length) {
            if (n.charAt(0) == '0') {
                StringBuffer stringBuffer = new StringBuffer(n);
                while (stringBuffer.length() > 0 && stringBuffer.charAt(0) == '0')
                    stringBuffer.delete(0, 1);
                if (stringBuffer.length() != 0)
                    ans.append(stringBuffer + ",");
                return;
            }
            ans.append(n + ",");
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            n.append(i);
            backtrack(n, (char) (i));
            n.delete(n.length() - 1, n.length());
        }
    }
}

class Test {
    public static void main(String[] args) {
        剑指Offer17打印从1到最大的n位数 test = new 剑指Offer17打印从1到最大的n位数();
        test.printNumbers(2);
    }
}
