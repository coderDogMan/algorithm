package array.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IsPalindrome {

    public static void main(String[] args) {
        boolean b = isPalindrome(0);
        System.out.println(b);
    }


    //题解
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revert = 0;
        while (x > revert) {
            revert = revert * 10 + x % 10;
            x /= 10;
        }

        return x == revert || x == revert / 10;
    }


    //自己写
//    public static boolean isPalindrome(int x) {
//        if (x < 0) return false;
//        int start;
//        int end;
//        List<Integer> list = new LinkedList<>();
//        while (x > 0) {
//            list.add(x % 10);
//            x /= 10;
//        }
//        start = 0;
//        end = list.size() - 1;
//        for (; start < end; start++,end--) {
//            if (list.get(start) != list.get(end)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
