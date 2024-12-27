package week.lcp2023;

import java.util.HashMap;
import java.util.Scanner;

public class T3 {
//    public int fieldOfGreatestBlessing(int[][] forceField) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int n = forceField.length;
//        for (int i = 0; i < n; i++) {
//            inr
//        }
//        return 0;
//    }

     public int[][] rangeAddQueries(int n, int[][] queries) {
         int[][] diff = new int[n + 1][n + 1];
         int[][] ret = new int[n + 1][n + 1];
        for(int[] q : queries) {
            diff[q[0]][q[1]]++;
            diff[q[0]][q[3]+1]--;
            diff[q[2]+1][q[1]]--;
            diff[q[2]+1][q[3]+1]++;
        }
        for(int i = 0; i < n; ++i)
            for(int j = 1; j < n; ++j) diff[i][j] += diff[i][j-1];
        for(int i = 1; i < n; ++i)
            for(int j = 0; j < n; ++j) diff[i][j] += diff[i-1][j];
        for(int i = 0; i < n; ++i)
            for(int j = 0; j < n; ++j) ret[i][j] = diff[i][j];
        return ret;
    }

}

class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] dp = new int[n][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = (j > 0 ? dp[i - 1][j - 1] : 0) + dp[i - 1][j];
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (dp[n - 1][j] % 2 == 1) ans++;
        }
        System.out.println(ans);
    }
}