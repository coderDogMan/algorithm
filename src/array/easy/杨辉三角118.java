package array.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 杨辉三角118 {
    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> item = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    item.add(1);
                } else {
                    item.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(item);
        }
        return list;
    }

//    public static List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> list = new ArrayList<>();
//
//        for (int i = 1; i <= numRows; i++) {
//            ArrayList<Integer> item = new ArrayList<>();
//            for (int j = 1; j <= i; j++) {
//                item.add(j);
//            }
//
//        }
//
//
//        return null;
//    }
}
