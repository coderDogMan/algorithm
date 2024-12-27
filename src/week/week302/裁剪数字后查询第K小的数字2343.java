package week.week302;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 裁剪数字后查询第K小的数字2343 {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] ans = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            PriorityQueue<String[]> pq = new PriorityQueue<String[]>((a, b) -> (a[0].compareTo(b[0])));
            for (int j = 0; j < nums.length; j++) {
                int start = nums[j].length() - query[1] < 0 ? 0 : nums[j].length() - query[1];
                String s = nums[j].substring(start);
                pq.add(new String[]{s, String.valueOf(j)});
            }
            while (query[0]-- > 1) {
                pq.poll();
            }
            ans[idx++] = Integer.parseInt(pq.poll()[1]);
        }
        return ans;
    }
}

class Test3 {
    public static void main(String[] args) {
        裁剪数字后查询第K小的数字2343 test = new 裁剪数字后查询第K小的数字2343();
//        test.smallestTrimmedNumbers(new String[]{"24","37","96","04"}, new int[][]{{2,1},{2,2}});
        test.smallestTrimmedNumbers(new String[]{"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"},
                new int[][]{{6,1}});
//                new int[][]{{1,1},{2,3},{4,2},{1,2}});
    }
}
