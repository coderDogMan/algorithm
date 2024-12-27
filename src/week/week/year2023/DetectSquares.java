package week.week.year2023;

import java.util.HashMap;

public class DetectSquares {
    HashMap<Integer, HashMap<Integer, Integer>> map;
    public DetectSquares() {
        map = new HashMap<>();
    }

    // x - y - y的个数
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        HashMap<Integer, Integer> col2Cnt = map.getOrDefault(x, new HashMap<>());
        col2Cnt.merge(y, 1, Integer::sum);
        map.put(x, col2Cnt);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int ans = 0;
        HashMap<Integer, Integer> col2Cnt = map.getOrDefault(x, new HashMap<>());
        for (Integer colKey : col2Cnt.keySet()) {
            if (colKey == y) continue;
            int diff = Math.abs(colKey - y);
            int cnt = col2Cnt.getOrDefault(colKey, 0);
            for (int d : new int[]{-diff, diff}) {
                HashMap<Integer, Integer> col2Cnt2Row = map.getOrDefault(x + d, new HashMap<>());
                Integer cnt2 = col2Cnt2Row.getOrDefault(y, 0);
                Integer cnt3 = col2Cnt2Row.getOrDefault(colKey, 0);
                ans += cnt * cnt2 * cnt3;
            }
        }
        return ans;
    }
}

class Test96 {
    public static void main(String[] args) {
        DetectSquares test = new DetectSquares();
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] {3, 10});
        detectSquares.add(new int[] {11, 2});
        detectSquares.add(new int[] {3, 2});
        System.out.println(detectSquares.count(new int[]{11, 10})); // 返回 1 。你可以选择：
        //   - 第一个，第二个，和第三个点
        System.out.println(detectSquares.count(new int[]{14, 8}));  // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
        detectSquares.add(new int[] {11, 2});    // 允许添加重复的点。
        System.out.println(detectSquares.count(new int[]{11, 10}));
    }
}
