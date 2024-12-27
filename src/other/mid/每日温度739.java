package other.mid;

import java.util.Deque;
import java.util.LinkedList;

public class 每日温度739 {
    public int[] dailyTemperatures(int[] temperatures) {
//        int[] answer = new int[temperatures.length];
//        Deque<Integer> stack = new LinkedList<>();
//        stack.add(0);
//        for (int i = 1; i < temperatures.length; i++) {
//            while (stack.size() != 0 && temperatures[i] > temperatures[stack.getLast()]) {
//                int index = stack.pop();
//                answer[index] = i - index;
//            }
//            stack.add(i);
//        }
//
//        return answer;
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
