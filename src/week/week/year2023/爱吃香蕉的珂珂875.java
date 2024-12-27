package week.week.year2023;

public class 爱吃香蕉的珂珂875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = (int) 1e9;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(piles, mid, h)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }

    // 每小时吃n个 ,花的时间与h比较
    private boolean check(int[] piles, double n, int h) {
        int res = 0;
        for (int pile : piles) {
            res += Math.ceil(pile / n);
        }
        return res <= h;
    }
}
