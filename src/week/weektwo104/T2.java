package week.weektwo104;

import java.util.PriorityQueue;

public class T2 {
    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;
        PriorityQueue<Integer>[] arr = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new PriorityQueue<>((a, b) -> (b - a));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i].add(nums[i][j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, arr[j].poll());
            }
            ans += max;
        }
        return ans;
    }
}

class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.matrixSum(new int[][]{
                {7,2,1},{6,4,2},{6,5,3},{3,2,1}
        });
    }
}