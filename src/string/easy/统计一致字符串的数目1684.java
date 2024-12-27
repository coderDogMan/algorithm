package string.easy;

import java.util.HashSet;

public class 统计一致字符串的数目1684 {
    public static void main(String[] args) {
        countConsistentStrings("ab",new String[]{"ad","bd","aaab","baa","badab"});
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        int sum = words.length;
        boolean arr[] = new boolean[26];
        char[] chars = allowed.toCharArray();
        for (char aChar : chars) {
            arr[aChar - 97] = true;
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!arr[c - 97]){
                    sum--;
                    break;
                }
            }
        }

        return sum;
    }

//    public static int countConsistentStrings(String allowed, String[] words) {
//        int sum = 0;
//
//        for (String word : words) {
//            char[] chars = word.toCharArray();
//            for(int i = 0; i < chars.length; i++) {
//                if (!allowed.contains(chars[i]+""))
//                    break;
//                else if (i == chars.length - 1)
//                    sum++;
//            }
//        }
//        return sum;
//    }
}
