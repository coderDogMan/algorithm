//package array.mid;
//
//public class 香槟塔799 {
//    public static void main(String[] args) {
//        double v = champagneTower(5, 2, 2);
//        System.out.println(v);
//    }
//
//    public static double champagneTower(int poured, int query_row, int query_glass) {
//        int deep = 1;
//        while (poured > deep){
//            poured -= deep;
//            deep++;
//        }
//
//        if (deep < query_row + 1) return 0d;
//        if (deep > query_row + 1) return 1d;
//        double pivot =  1/ Math.pow(2, query_row);
//        double res = 0;
//        if (query_glass <= (deep+1) / 2 + 1) {
//            for (int i = 0; i <= query_glass; i++) {
//                res += ((i + 1) * pivot);
//            }
//            return res;
//        } else {
//            int n = 1;
//            for (int i = (deep+1) / 2 + 1; i <= query_glass; i++) {
//                res -= ((++/n + 1) * pivot);
//            }
//            return res;
//        }
//    }
//}
