package array.hard;

import java.util.Deque;
import java.util.LinkedList;

public class 滑动窗口最大值239 {
    public static void main(String[] args) {
//        maxSlidingWindow(new int[]{7,2,4}, 2);
        maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 1) return nums;
        int len = nums.length - k + 1;
        int res[] = new int[len];
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.add(nums[i]);
        }
        res[0] = myQueue.peek();
        int index = 1;
        for (int i = k; i < nums.length; i++) {
            myQueue.poll(nums[i - k]);
            myQueue.add(nums[i]);
            res[index++] = myQueue.peek();
        }
        return res;
    }

    static class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        public void poll(int val) {
            if (!deque.isEmpty() && deque.peek() == val) {
                deque.poll();
            }
        }

        public void add(int val) {
            while (!deque.isEmpty() && val > deque.getLast()){
                deque.removeLast();
            }
            deque.add(val);
        }

        public int peek() {
            return deque.peek();
        }

    }

}


