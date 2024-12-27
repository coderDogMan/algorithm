package string.easy;

import java.util.Arrays;

public class 面试题判定是否互为字符重排 {
    public static void main(String[] args) {

    }

    public boolean CheckPermutation(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

//    public boolean CheckPermutation(String s1, String s2) {
//        char[] chars1 = s1.toCharArray();
//        char[] chars2 = s2.toCharArray();
//        char c = 0;
//        for (char c1 : chars1)
//            c ^= c1;
//        for (char c1 : chars2)
//            c ^= c1;
//        return c == 0;
//    }

}
