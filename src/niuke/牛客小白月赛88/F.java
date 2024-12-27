//package niuke.牛客小白月赛88;
//
//import java.util.Scanner;
//
//public class F {
//
//    static int n;
//    static int m;
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        n = in.nextInt();
//        m = in.nextInt();
//        int d = in.nextInt();
//        int num = (n - d) * m;
//        byte[][] vis = new byte[n][m];
//
//        for (int i = 0; i <= m; i++) {
//            if (UL(i, 0, num, vis)) {
//                System.out.println("UL");
//                return;
//            } else if (UR(i, 0)) {
//                System.out.println("UL");
//                return;
//            } else if (DL(i, 0)) {
//                System.out.println("UL");
//                return;
//            } else if (DR(i, 0)) {
//                System.out.println("DR");
//                return;
//            } else {
//                System.out.println("NO");
//            }
//        }
//
//    }
//
//    private static boolean UL(int x, int y, int num, byte[][] vis) {
//        if (x == 0 && y == 0 || x == 0 || y == 0) return false;
//        if (x == 0) {
//            UR(x, y + 1, num - (vis[x][y] > 0 ? 0 : 1), vis[x][y] | 1 << 0);
//        }
//        if (y == 0) {
//
//        }
//
//
//    }
//}
