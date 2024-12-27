package week.weektwo99;

import java.util.PriorityQueue;

public class 最小和分割6312 {
    public int splitNum(int num) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while (num > 0) {
            queue.add(num % 10);
            num /= 10;
        }
        int num1 = 0;
        int num2 = 0;
        while (queue.size() > 1) {
            num1 = num1 * 10 + queue.poll();
            num2 = num2 * 10 + queue.poll();
        }
        if (queue.size() != 0) {
            if (num1 < num2) {
                num1 = num1 * 10 + queue.poll();
            } else {
                num2 = num2 * 10 + queue.poll();
            }
        }
        return  num1 + num2;
    }
}

