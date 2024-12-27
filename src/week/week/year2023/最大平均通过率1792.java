package week.week.year2023;

import java.util.PriorityQueue;

public class 最大平均通过率1792 {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<Double[]> queue = new PriorityQueue<>((a, b) -> {
            Double b1 = (b[1] + 1) / (b[2] + 1) - b[1] / b[2];
            Double a1 =  (a[1] + 1) / (a[2] + 1) - a[1] / a[2];
            return b1.compareTo(a1);
        });
        int good = 0;
        for (int[] aClass : classes) {
            double pass = aClass[0];
            double total = aClass[1];
            if (pass == total) {
                good++;
                continue;
            }
            queue.add(new Double[]{pass / total, pass, total});
        }
        while (!queue.isEmpty() && extraStudents-- > 0){
            Double[] poll = queue.poll();
            double pass = poll[1] + 1;
            double total = poll[2] + 1;
            queue.add(new Double[]{pass / total, pass, total});
        }
        double ans = good;
        while (!queue.isEmpty()) {
            ans += queue.poll()[0];
        }
        return ans / n;
    }

}

class Test70 {
    public static void main(String[] args) {
        最大平均通过率1792 test = new 最大平均通过率1792();
        test.maxAverageRatio(new int[][]{{2,4},{3,9},{4,5},{2,10}}, 2);
//        test.maxAverageRatio(new int[][]{{1, 2}, {3, 5}, {2, 2}}, 2);
    }
}
