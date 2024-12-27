package array.easy;


import java.util.ArrayList;
import java.util.List;

public class 杨辉三角119_2 {
    public static void main(String[] args) {
        List<Integer> row = getRow(3);
        System.out.println(row);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            list.add(0);
            for (int j = i; j > 0; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
        }
        return list;
    }

//    public static List<Integer> getRow(int rowIndex) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i <= rowIndex; i++) {
//            List<Integer> row = new ArrayList<>();
//            for (int j = 0; j <= i; j++) {
//                if (j == 0 || j == i) {
//                    row.add(1);
//                } else {
//                    row.add(list.get(j - 1) + list.get(j));
//                }
//            }
//            list = row;
//        }
//        return list;
//    }

//    public static List<Integer> getRow(int rowIndex) {
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i <= rowIndex; i++) {
//            List<Integer> row = new ArrayList<>();
//            for (int j = 0; j <= i; j++) {
//                if (j == 0 || j == i) {
//                    row.add(1);
//                } else {
//                    row.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
//                }
//            }
//            list.add(row);
//        }
//        return list.get(rowIndex);
//    }
}
