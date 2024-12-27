package other.hard;

import java.util.Scanner;

public class 情报员 {
    static String s;
    static int[][] map;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        s = in.next();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j, 0)){
                    System.out.println("Find");
                    return;
                }
            }
        }
        System.out.println("Not Find");
    }

    private static boolean dfs(int row, int col, int idx) {
        if (idx == s.length()) return true;
        if (row == -1 || col == -1 || row == map.length || col == map[0].length || map[row][col] == -1) return false;
        if (map[row][col] != s.charAt(idx) - '0') return false;
        int temp = map[row][col];
        map[row][col] = -1;
        if (dfs(row - 1, col, idx + 1)) return true;
        if (dfs(row + 1, col, idx + 1)) return true;
        if (dfs(row, col - 1, idx + 1)) return true;
        if (dfs(row, col + 1, idx + 1)) return true;
        map[row][col] = temp;
        return false;
    }
}
