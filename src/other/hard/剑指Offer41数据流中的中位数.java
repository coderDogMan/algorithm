package other.hard;

import java.util.PriorityQueue;

public class 剑指Offer41数据流中的中位数 {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    /** initialize your data structure here. */
    public 剑指Offer41数据流中的中位数() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<Integer>((a, b) -> ((b - a)));
    }

    public void addNum(int num) {
        if (max.isEmpty() || num < max.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }

        if (min.size() >= max.size() + 2) {
            max.add(min.poll());
        }
        if (max.size() >= min.size() + 2) {
            min.add(max.poll());
        }
    }

    public double findMedian() {
        if (max.isEmpty()) return min.peek();
        if (min.isEmpty()) return max.peek();
        if ((min.size() + max.size()) % 2 != 0) {
            return min.size() > max.size() ? min.peek() : max.peek();
        } else {
            return (double) (min.peek() + max.peek()) / 2;
        }
    }
}

class Test8 {
    public static void main(String[] args) {
        剑指Offer41数据流中的中位数 test = new 剑指Offer41数据流中的中位数();
        test.addNum(1);
        test.addNum(2);
        System.out.println(test.findMedian());
        test.addNum(3);
        System.out.println(test.findMedian());
    }
}