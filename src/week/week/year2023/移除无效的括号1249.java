package week.week.year2023;

import java.util.LinkedList;

public class 移除无效的括号1249 {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        LinkedList<Integer> stackL = new LinkedList<>();
        LinkedList<Integer> stackR = new LinkedList<>();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                stackL.add(i);
            } else if (chars[i] == ')' && !stackL.isEmpty()) {
                stackL.pollLast();
            } else if (chars[i] == ')') {
                stackR.add(i);
            }
        }
        StringBuilder sb = new StringBuilder(s);
        int idx = 0;
        while (!stackL.isEmpty()) {
            Integer pollLast = stackL.pollLast();
            sb.delete(pollLast - idx, pollLast + 1 - idx);
            idx++;
        }
        while (!stackR.isEmpty()) {
            Integer pollLast = stackR.pollLast();
            sb.delete(pollLast - idx, pollLast + 1);
        }
        return sb.toString();
    }
}

class Test2 {
    public static void main(String[] args) {
        移除无效的括号1249 test = new 移除无效的括号1249();
        test.minRemoveToMakeValid("))((");
//        test.minRemoveToMakeValid("lee(t(c)o)de)");

    }
}