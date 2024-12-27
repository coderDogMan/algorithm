//package writtentest.pdd2023;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class 团建 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String[] strings = new String[n];
//        for (int i = 0; i < n; i++) {
//            strings[i] = in.next();
//        }
////        int[] arr1 = new int[] {};
//        int ANum = in.nextInt();
//        int APrice = in.nextInt();
//        int BNum = in.nextInt();
//        int BPrice = in.nextInt();
//        int CNum = in.nextInt();
//        int CPrice = in.nextInt();
//        Arrays.sort(strings, (a, b) -> (a.length() - b.length()));
//        int i = 0;
//        int A = 0;
//        int B = 0;
//        int C = 0;
//        // 长度1
//        for (; i < n; i++) {
//            if (strings[i].length() == 1) {
//                if (strings[i].charAt(0) == 'A' &&  A < ANum){
//                    A++;
//                } else if (strings[i].charAt(0) == 'B' &&  B < BNum) {
//                    B++;
//                } else if (strings[i].charAt(0) == 'C' && C < CNum){
//                    C++;
//                } else {
//                    System.out.println("NO");
//                    System.out.println(A + B + C);
//                    return;
//                }
//            } else {
//                break;
//            }
//        }
//
//        // 长度2选小的
//        for (; i < n; i++) {
//            if (strings[i].length() == 2) {
//                if (strings[i].contains("A") && A < ANum){
//                    A++;
//                } else if (strings[i].contains("B") && B < BNum) {
//                    B++;
//                } else if (strings[i].contains("C") && C < CNum){
//                    C++;
//                } else {
//                    System.out.println("NO");
//                    System.out.println(A + B + C);
//                    return;
//                }
//            } else {
//                break;
//            }
//        }
//        int yu = n - i;
//        if (ANum + BNum + CNum - (A + B + C) < yu) {
//            System.out.println("NO");
//            System.out.println(A + B + C);
//            return;
//        }
//
//        if ((A + yu) % (ANum + 1) <= ANum) {
//            yu -= ANum - A;
//            A += ANum - A;
//        } else {
//            yu -= ANum - A;
//            A = ANum;
//        }
//
//        if ((B + yu) % (BNum + 1) <= BNum) {
//            yu -= ANum - B;
//
//            B += ANum - B;
//        } else {
//            yu -= BNum - B;
//            yu -= ANum - A;
//        }
//
//        if ((C + yu) % (CNum + 1) <= CNum) {
//            C += yu;
//        }
//        System.out.println("YES");
//        System.out.println(A * APrice + B * BPrice + C * CPrice);
//    }
//}
