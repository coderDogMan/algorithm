//package writtentest.szml;
//
//
//import com.sun.tools.javac.util.Pair;
//
//import java.util.Scanner;
//
//public class T3 {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int av = in.nextInt();
//        int bv = in.nextInt();
//        int cv = in.nextInt();
//        int x = in.nextInt();
//        if (Math.abs(x - av) < Math.abs(x - bv) && Math.abs(x - av) < Math.abs(x - cv)) {
//            System.out.println("A");
//        } else if (Math.abs(x - bv) < Math.abs(x - av) && Math.abs(x - bv) < Math.abs(x - cv)) {
//            System.out.println("B");
//        } else if (Math.abs(x - cv) < Math.abs(x - av) && Math.abs(x - cv) < Math.abs(x - bv)) {
//            System.out.println("C");
//        } else {
//            System.out.println("same");
//        }
//    }
//}
//interface test1 {
//}
//interface MyInterface {
//    default void myMethod() {
//        System.out.println("Default implementation of myMethod");
//    }
//}
//
//abstract class test2 {
//    int x;
//}
//class Main {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) nums[i] = i + 1;
//        int[] dp = new int[m + 1];
//        dp[0] = 1;
//        for (int i = 0; i < n; i++) {
//            for (int j = m; j - nums[i] >= 0; j--) {
//                dp[j] += dp[j - nums[i]];
//            }
//        }
//        System.out.println(dp[m]);
//    }
//}
