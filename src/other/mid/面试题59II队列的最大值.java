package other.mid;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class 面试题59II队列的最大值 {
    PriorityQueue<Integer> pq;
    LinkedList<Integer> q;

    public 面试题59II队列的最大值() {
        pq = new PriorityQueue<Integer>((a, b) -> (b - a));
        q = new LinkedList<Integer>();
    }

    public int max_value() {
        if (pq.isEmpty()) return -1;
        return pq.peek();
    }

    public void push_back(int value) {
        q.addLast(value);
        pq.add(value);
    }

    public int pop_front() {
        int num = q.poll();
        pq.remove(num);
        return num;
    }
}


class Test4 {
    public static void main(String[] args) {
        面试题59II队列的最大值 test = new 面试题59II队列的最大值();
        test.push_back(1);
        test.push_back(2);
        test.push_back(1);
        System.out.println(test.max_value());
        System.out.println(test.pop_front());
        System.out.println(test.max_value());

        System.out.println(test.pop_front());
        System.out.println(test.max_value());
    }
}