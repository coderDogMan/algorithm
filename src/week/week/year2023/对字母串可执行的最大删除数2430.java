//package week.week;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.HashSet;
//
//public class 对字母串可执行的最大删除数2430 {
//
//    String s;
//    int[] memo;
//    public int deleteString(String s) {
//        int n = s.length();
//        memo = new int[n];
//        Arrays.fill(memo, -1);
//
//        this.s = s;
//        return dfs(0);
//    }
//
//    private int dfs(int i) {
//        if (i == s.length()) return 1;
//        if (memo[i] != -1) return memo[i];
//        int res = 1;
//        for (int j = i + 1; j <= s.length() / 2; j++) {
//            if (s.substring(i, j).equals(s.substring(j,j * 2 + i))){
//                res = Math.max(res, dfs(j) + 1);
//            }
//        }
//        memo[i] = res;
//        return res;
//    }
//}
//
//
//class Test55 {
//    public static void main(String[] args) {
//        对字母串可执行的最大删除数2430 test = new 对字母串可执行的最大删除数2430();
////        test.deleteString("aaaaa");
//        test.deleteString("abcabcdabc");
////        test.deleteString("aaabaab");
//    }
//}