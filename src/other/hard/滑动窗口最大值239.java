package other.hard;

import java.util.LinkedList;

public class 滑动窗口最大值239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        MyQueue queue = new MyQueue();
        int index = 0;
        for (int i = 0; i < k; i++) {
            queue.push(nums[i]);
        }
        for (int i = k - 1; i < nums.length - 1; i++) {
            ans[index++] = queue.getMax();
            queue.pop(nums[i - k + 1]);
            queue.push(nums[i + 1]);
        }
        ans[index] = queue.getMax();
        return ans;
    }


}

class MyQueue {
    LinkedList<Integer> queue = new LinkedList<>();

    public void pop(int num) {
        if (!queue.isEmpty() && queue.peek() == num) {
            queue.pop();
        }
    }

    public void push(int num) {
        while (!queue.isEmpty() && queue.getLast() < num) {
            queue.removeLast();
        }
        queue.addLast(num);
    }

    public int getMax() {
        return queue.peek();
    }

}

class Test {
    public static void main(String[] args) {
        滑动窗口最大值239 test = new 滑动窗口最大值239();
//        test.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        test.maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3);
    }
}

