//package writtentest.baidu20231017;
//
//import java.util.Scanner;
//
//public class A {
//    static String[] time;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        time = new String[n];
//        int[] sum = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            time[i] = in.next() + in.next();
//            int x = in.nextInt();
//            sum[i + 1] = sum[i] + x;
//        }
//        int m = in.nextInt();
//        while (m-- > 0) {
//            String start = in.next() + in.next();
//            String end = in.next() + in.next();
//            int l = find(start);
//            int r = find(end + "1");
//            System.out.println(sum[r] - sum[l]);
//        }
//    }
//
//    //找到大于等于s 的下标
//    private static int find(String s) {
//        int l = 0;
//        int r = time.length - 1;
//        while (l <= r) {
//            int mid = (l + r) / 2;
//            if (time[mid].compareTo(s) >= 0) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return l ;
//    }
//}
