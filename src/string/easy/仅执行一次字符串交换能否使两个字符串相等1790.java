package string.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class 仅执行一次字符串交换能否使两个字符串相等1790   {
    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));

    }
//"bank"
//"kanb"
    public static boolean areAlmostEqual(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        LinkedList<String> linkedList = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) {
                count++;
                if (!linkedList.contains(chars1[i] + "")) {
                    linkedList.add(chars1[i] + "");
                } else {
                    linkedList.remove(chars1[i] + "");
                }
                if (!linkedList.contains(chars2[i] + "")) {
                    linkedList.add(chars2[i] + "");
                } else {
                    linkedList.remove(chars2[i] + "");
                }
            }
        }
        if (linkedList.size() != 0) return false;
        return count == 2 || count == 0;
    }
}
