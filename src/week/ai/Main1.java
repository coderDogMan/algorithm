package week.ai;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Main1 {
    public int longestValidParentheses (String s) {
        int n = s.length();
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> stackPoll = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || s.charAt(i) == '(') {
                stack.add(i);
            } else {
                if (s.charAt(stack.getLast()) == '(') {
                    stackPoll.add(stack.pollLast());
                    stackPoll.add(i);
                }
            }
        }
        int ans = 0;
        int cur = 1;
        Collections.sort(stackPoll);
        for (int i = 1; i < n; i++) {
            if (stackPoll.get(i - 1) == stackPoll.get(i)) {
                cur++;
            } else {
                cur = 1;
            }
            ans = Math.max(ans, cur);
        }

        return ans;
    }
}
