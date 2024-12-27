package week.week312;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 按身高排序6188 {

    public static void main(String[] args) {
        String[] strings = sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170});
        String[] strings2 = sortPeople(new String[]{"Alice","Bob","Bob"}, new int[]{155,185,150});
        System.out.println(strings);
        System.out.println(strings2);
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] < heights[j]) {
                    int temp1 = heights[i];
                    heights[i] = heights[j];
                    heights[j] = temp1;
                    String temp2 = names[i];
                    names[i] = names[j];
                    names[j] = temp2;
                }
            }
        }

        return names;
    }

//
//
//    public static String[] sortPeople(String[] names, int[] heights) {
//        HashMap<Integer, String> map = new HashMap<>();
//
//        for (int i = 0; i < names.length; i++) {
//            map.put(heights[i], names[i]);
//        }
//
////        for (int i = 0; i < names.length; i++) {
////            names[i] = entry[i].getKey();
////        }
//        return names;
//    }

}
