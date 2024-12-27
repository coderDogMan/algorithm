package week.week.year2024firstQuarter;

public class Alice和Bob玩鲜花游戏3021 {

    public long flowerGame(int n, int m) {
        long nj = (n + 1) / 2;
        long no = n - nj;
        long mj = (m + 1) / 2;
        long mo = m - mj;

        return nj * mo + mj * no;

    }

}
