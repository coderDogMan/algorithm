//package array.mid;
//
//public class 第K个语法符号779 {
//    public static void main(String[] args) {
//        int i = kthGrammar(2, 2);
//        System.out.println(i);
//    }
//
////    0
////    01
////    0110
////    01101001
////    0110100110010110
//
//// 3 2
//    public static int kthGrammar(int n, int k) {
//        if (n == 1) return 0;
//
//
//        return  kthGrammar(n - 1, (k + 1) / 2 + 1) + kthGrammar(n - 1, (k + 1) / 2);
//    }
//}
