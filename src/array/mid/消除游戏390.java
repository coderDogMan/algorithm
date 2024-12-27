package array.mid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 消除游戏390 {
    public static void main(String[] args) {
        int i = lastRemaining(9);
        System.out.println(i);
    }

    public static int lastRemaining(int n) {
        int num = 1;
        int xunHanNum = 0;
        int step = 1;
        while (n > 1) {
            if (xunHanNum % 2 == 0) {
                num += step;
            } else {
                num = n % 2 == 0 ? num : num + step;
            }
            xunHanNum++;
            n >>= 1;
            step <<= 1;
        }

        return num;
    }

//    public static int lastRemaining(int n) {
//        List<Integer> list = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(i + 1);
//        }
//        boolean flag = true;
//        while (list.size() > 1) {
//            if (flag) {
//                for (int i = 0; i < list.size(); i++) {
//                    list.remove(i);
//                }
//                flag = !flag;
//            } else {
//                for (int i = list.size() - 1; i >= 0; i-=2) {
//                    list.remove(i);
//                }
//                flag = !flag;
//            }
//        }
//        return list.get(0);
//    }
}
