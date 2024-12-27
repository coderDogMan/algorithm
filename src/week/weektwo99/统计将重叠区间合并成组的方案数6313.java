package week.weektwo99;

import java.util.Arrays;

public class 统计将重叠区间合并成组的方案数6313 {
    public int countWays(int[][] ranges) {
        if (ranges.length == 1) return 2;
        Arrays.sort(ranges, (a1, a2) -> (a1[0] - a2[0]));
        int n = 1;
        int right = ranges[0][1];
        for (int i = 0; i < ranges.length - 1; i++) {
            if (ranges[i][1] < ranges[i + 1][0]) {
                n++;
            } else {
                ranges[i + 1][1] = Math.max(ranges[i][1], ranges[i + 1][1]);
            }
        }

        return (int)(Math.pow(2, n) % 1000000007);
    }
}

class Test {
    public static void main(String[] args) {
        统计将重叠区间合并成组的方案数6313 test = new 统计将重叠区间合并成组的方案数6313();
//        test.countWays(new int[][]{
//                {34,56},{28,29},{12,16},{11,48},{28,54},{22,55},{28,41},{41,44}
//        });
//        test.countWays(new int[][]{
//                {0,0},{8,9},{12,13},{1,3}
//        });
        test.countWays(new int[][]{{6, 10}, {5, 15}});
    }
}
