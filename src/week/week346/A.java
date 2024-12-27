package week.week346;

import java.util.LinkedList;

public class A {
    public int minLength(String s) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && ((stack.getLast() == 'A' && c == 'B') || (stack.getLast() == 'C' && c == 'D'))) {
                stack.pollLast();
            } else {
                stack.addLast(c);
            }
        }
        return stack.size();
    }
}

class Test1 {
    public static void main(String[] args) {
        A a = new A();
        a.minLength("ABFCACDB");
    }
}