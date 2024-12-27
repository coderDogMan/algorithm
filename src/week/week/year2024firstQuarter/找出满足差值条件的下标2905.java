package week.week.year2024firstQuarter;

import java.util.PriorityQueue;

public class 找出满足差值条件的下标2905 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((a, b) -> (nums[b] - nums[a]));
        PriorityQueue<Integer> minQ = new PriorityQueue<>((a, b) -> (nums[a] - nums[b]));
        for (int i = indexDifference; i < nums.length; i++) {
            maxQ.add(i);
            minQ.add(i);
        }
//        if (indexDifference == 0 && maxQ.peek() - minQ.peek() >= valueDifference) return new int[] {Math.min(maxQ.peek(), minQ.peek()), Math.min(maxQ.peek(), minQ.peek())};
//        else if (indexDifference == 0) return new int[] {-1, -1};
//        minQ.remove(indexDifference);
//        maxQ.remove(indexDifference);
        int max = 0;
        int min = 0;
        for (int i = 0; i < nums.length - indexDifference; i++) {
            if (nums[i] > nums[max]) max = i;
            if (nums[i] < nums[min]) min = i;
            if (Math.abs(nums[maxQ.peek()] - nums[min]) >= valueDifference) {
                return new int[] {min, maxQ.peek()};
            } else if (Math.abs(nums[max] - nums[minQ.peek()]) >= valueDifference) {
                return new int[] {max, minQ.peek()};
            }
            maxQ.remove(i);
            minQ.remove(i);
        }


        return new int[] {-1, -1};
    }
}
