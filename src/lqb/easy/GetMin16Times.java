package lqb.easy;
/**
 * 8518 是一个非常特殊的数，如果把这个数看成 16 进制数，它的值为 (8518)16=8*16*16*16+5*16*16+1*16+8=34072，而 34072 正好是 8518 的整数倍。
 * 　　9558 也是这样一个数，当看成 16 进制时是 38232。
 * 　　其实长度为 1 的数 0 到 9 都满足看成 16 进制后是自己的整数倍（1倍）。
 * 　　请问，除开长度为 1 的数，最小的满足这样条件的数是多少？
 * */
public class GetMin16Times {
    public static void main(String[] args) {

        for (int i = 2; ;i++) {
            int bin = 0;
            String s = i + "";
            for (int j = 0; j < s.length(); j++) {
                bin = bin * 16 + (s.charAt(j) - '0');
            }
            if (bin % i == 0 && bin != i) {
                System.out.println(i);
                break;
            }
        }
    }
}
