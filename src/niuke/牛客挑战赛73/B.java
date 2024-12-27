//package niuke.牛客挑战赛73;
//
//
//import java.util.Scanner;
//
//public class B {
//    static int n;
//    static int m;
//    static String[] map;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        m = in.nextInt();
//        String[] row = new String[m];
//        String[] col = new String[n];
//        for (int i = 0; i < n; i++) {
//            map[i] = in.next();
//        }
//        row[0] = map[0].charAt(0) + "";
//        col[0] = map[0].charAt(0) + "";
//        for (int j = 1; j < m; j++) row[0] = row[j - 1] + map[0].charAt(j);
//        for (int i = 1; i < n; i++) col[i] = col[i - 1] + map[i].charAt(0);
//
//        for (int i = 1; i < n; i++) {
//            if (row[1].compareTo(col[i]) < 0) row[1] = row[1] + map[i].charAt(1);
//            else row[1] = col[i] + map[i].charAt(1);
//            for (int j = 2; j < m; j++) {
//                col[]
//            }
//        }
//        System.out.println(dp[n - 1][m - 1]);
//
//    }
//
//}
