package week.weektwo129;

public class T1 {

    public boolean canMakeSquare(char[][] grid) {
        boolean ans = false;
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                int b = 0, w = 0;
                if (grid[i][j] == 'W') w++;
                else b++;
                if (grid[i + 1][j] == 'W') w++;
                else b++;
                if (grid[i + 1][j + 1] == 'W') w++;
                else b++;
                if (grid[i][j + 1] == 'W') w++;
                else b++;
                if (b >= 3 || w >= 3) ans = true;
            }
        }
        return ans;
    }
}
