package writtentest.yongyou2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 大数减法 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String s1 = in.readLine();
//        String s2 = in.readLine();
//        if (s1.equals(s2)) System.out.println(0);
//        else if (s1.length() > s2.length()) {
////            int idx1 =
//
//
//
//        }
//    }


    public static void main(String[] args) {
        String num1 = "12";
        String num2 = "111";
        String result = subtract(num1, num2);
        System.out.println(result);
    }

    public static String subtract(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] a = new int[len1];
        int[] b = new int[len2];
        // 将字符串转换为整数数组，从个位开始存储
        for (int i = len1 - 1; i >= 0; i--) {
            a[len1 - 1 - i] = num1.charAt(i) - '0';
        }
        for (int i = len2 - 1; i >= 0; i--) {
            b[len2 - 1 - i] = num2.charAt(i) - '0';
        }
        // 计算差值并存储到数组中
        int[] res = new int[Math.max(len1, len2)];
        int carry = 0;
        for (int i = 0; i < res.length; i++) {
            int diff = (i < len1 ? a[i] : 0) - (i < len2 ? b[i] : 0) - carry;
            if (diff < 0) {
                diff += 10;
                carry = 1;
            } else {
                carry = 0;
            }
            res[i] = diff;
        }
        // 将整数数组转换为字符串
        StringBuilder sb = new StringBuilder();
        int i = res.length - 1;
        while (i >= 0 && res[i] == 0) {
            i--;
        }
        if (i < 0) {
            return "0";
        }
        while (i >= 0) {
            sb.append(res[i--]);
        }
        return sb.toString();
    }
}
