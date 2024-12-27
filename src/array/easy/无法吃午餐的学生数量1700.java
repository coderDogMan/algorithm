package array.easy;

import java.util.LinkedList;
import java.util.Queue;

public class 无法吃午餐的学生数量1700 {
    public static void main(String[] args) {
        int i = countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1});
        System.out.println(i);
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < students.length; i++)
            queue.offer(students[i]);
        int p = 0;
        while (true) {
            int size = queue.size();
            for (int i = 0; i < queue.size(); i++) {
                if (queue.peek() == sandwiches[p]) {
                    queue.poll();
                    p++;
                } else {
                    queue.offer(queue.poll());
                }
            }
            if (size == queue.size()) break;
            if (queue.size() == 0) return 0;
        }
        return queue.size();
    }
}
