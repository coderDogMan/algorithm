package string.easy;

import java.util.*;

public class 有效的字母异位词242 {
    public static void main(String[] args) {
        boolean anagram = isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int n = 0;
        for (int i = 0; i < chars.length; i++) {
            n += chars[i];
            n -= chart[i];
        }
        return n == 0;
    }

//    public static boolean isAnagram(String s, String t) {
//        char[] chars = s.toCharArray();
//        char[] chart = t.toCharArray();
//        Arrays.sort(chars);
//        Arrays.sort(chart);
//        return Arrays.equals(chars, chart);
//    }

//    public static boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        char[] chars = s.toCharArray();
//        char[] chart = t.toCharArray();
//        HashMap<Character, Integer> hashMaps = new HashMap<>();
//        HashMap<Character, Integer> hashMapt = new HashMap<>();
//        for (char aChar : chars) {
//            if (hashMaps.containsKey(aChar)) {
//                hashMaps.put(aChar, hashMaps.get(aChar) + 1);
//            } else {
//                hashMaps.put(aChar, 1);
//            }
//        }
//        for (char aChar : chart) {
//            if (hashMapt.containsKey(aChar)) {
//                hashMapt.put(aChar, hashMapt.get(aChar) + 1);
//            } else {
//                hashMapt.put(aChar, 1);
//            }
//        }
//        if (hashMaps.size() != hashMapt.size()) return false;
//        Set<Character> characters = hashMaps.keySet();
//        for (Character character : characters) {
//            if (hashMaps.get(character) == null)
//                return false;
//            if (hashMapt.get(character) == null)
//                return false;
//            if (!Objects.equals(hashMaps.get(character),hashMapt.get(character)))
//                return false;
//        }
//        return true;
//    }
}
