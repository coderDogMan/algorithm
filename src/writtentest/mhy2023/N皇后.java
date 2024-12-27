package writtentest.mhy2023;

import java.util.HashSet;
import java.util.Scanner;

public class N皇后 {
//    static int N;
//    static int num;
//    static int ans;
//    static char[][] queen;
//    static String[] strs;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        HashSet<Integer> dia1 = new HashSet<>();
        HashSet<Integer> dia2 = new HashSet<>();
        int c;
        for (int i = 0; i < n; i++) {
            String s = in.next();
            c = s.indexOf('*');
            if (c != -1) {
                row.add(i);
                col.add(c);
                dia1.add(i + c);
                dia2.add(i - c);
            }

        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (row.contains(i) || col.contains(j) || dia1.contains(i + j) || dia2.contains(i - j)) continue;
                ans++;
            }
        }
        System.out.println(ans);
    }

//    private static void backtrack(char[][] queen, int row, int n) {
//        if (n != num) {
//            ans++;
//            return;
//        }
//        for (int i = 0; i < N; i++) {
//            if (isOk(row, i)) {
//                queen[row][i] = '*';
//                backtrack(queen, row + 1, n + 1);
//                queen[row][i] = '.';
//            }
//        }
//    }
//
//    private static boolean isOk(int row, int col) {
//        for (int i = row - 1; i >= 0; i--) {
//            if (queen[i][col] == '*') return false;
//        }
//        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//            if (queen[i][j] == '*') return false;
//        }
//        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
//            if (queen[i][j] == '*') return false;
//        }
//        return true;
//    }
}
