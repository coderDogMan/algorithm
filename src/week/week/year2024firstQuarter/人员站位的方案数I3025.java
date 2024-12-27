package week.week.year2024firstQuarter;

public class 人员站位的方案数I3025 {

    int[][] points;
    public int numberOfPairs(int[][] points) {
        this.points = points;
        int ans = 0;

        for (int[] point : points) {
            ans += check(point[0], point[1]);
        }
        return ans;

    }

    private int check(int x, int y) {
        int res = 0;
        for (int[] point : points) {
            //存在 右下角
            if (x == point[0] && y == point[1]) continue;
            if (x <= point[0] && y >= point[1]) {
                //中间没有任何点
                for (int[] p : points) {
                    if ((p[0] == x && p[1] == y) || (p[0] == point[0] && p[1] == point[1])) continue;
                    if (x <= p[0] && p[0] <= point[0] && point[1] <= p[1] && p[1] <= y) {
                        res--;
                        break;
                    }
                }
                res++;
            }
        }
        return res;
    }

}

class Test2 {
    public static void main(String[] args) {

        人员站位的方案数I3025 t2 = new 人员站位的方案数I3025();
        t2.numberOfPairs(new int[][]{{1,3},{3,1},{1,1}});
//        t2.numberOfPairs(new int[][]{{6,2},{4,4},{2,6}});


    }
}