package string.mid;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列784 {
    public static void main(String[] args) {
//        System.out.println((int)'a');
//        System.out.println((int)'z');
//        System.out.println((int)'A');
//        System.out.println((int)'Z');
        letterCasePermutation("a1b2");

    }

    public static List<String> letterCasePermutation(String s) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        String temp = "";
        for (int i = 0; i< chars.length; i++) {
            if (chars[i] >= 97 && chars[i] <= 122) {
                res.add(temp + chars[i] + s.substring(i+1));
                res.add(temp + (char)(chars[i] - 32) + s.substring(i+1));
                temp += chars[i];
                continue;
            }
            if (chars[i] >= 65 && chars[i] <= 90) {
                res.add(temp + chars[i] + s.substring(i+1));
                res.add(temp + (char)(chars[i] + 32) + s.substring(i+1));
                temp += chars[i];
                continue;
            }
            temp += chars[i];

           //if (i == chars.length - 1) res.add(temp);
        }

        return res;
    }

}
