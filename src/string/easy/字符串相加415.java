package string.easy;

import javax.jws.soap.SOAPBinding;
public class 字符串相加415 {
    public static void main(String[] args) {
        System.out.println(addStrings("99", "1"));
    }

    public static String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int mod = 0;
        StringBuffer res = new StringBuffer();
        while (i1 >= 0 && i2 >= 0) {
            int temp = chars1[i1--] - '0' + chars2[i2--] - '0' + mod;
            mod = temp / 10;
            res.append(temp % 10 + "");
        }
        while (i1 >= 0) {
            int temp = chars1[i1--] - '0' + mod;
            mod = temp / 10;
            res.append(temp % 10 + "");
        }
        while (i2 >= 0) {
            int temp = chars2[i2--] - '0' + mod;
            mod = temp / 10;
            res.append(temp % 10 + "");
        }
        if (mod != 0) res.append("1");
        return res.reverse().toString();
    }

}
