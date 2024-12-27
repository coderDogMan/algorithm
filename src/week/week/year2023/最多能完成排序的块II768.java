package week.week.year2023;

import java.util.PriorityQueue;

public class 最多能完成排序的块II768 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> (b - a));
        for (int num : arr) {
            minQueue.add(num);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            minQueue.remove(arr[i]);
            maxQueue.add(arr[i]);
            if (maxQueue.peek() <= ( minQueue.isEmpty() ? 0 : minQueue.peek())) ans++;
        }
        return ans;

    }
}
class Test35 {
    public static void main(String[] args) {
        最多能完成排序的块II768 test = new 最多能完成排序的块II768();
        test.maxChunksToSorted(new int[]{1,1,0,0,1});
    }
}
