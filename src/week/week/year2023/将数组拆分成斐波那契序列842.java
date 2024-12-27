package week.week.year2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 将数组拆分成斐波那契序列842 {

    List<Integer> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<Integer> splitIntoFibonacci(String num) {
        if (num.length() < 3) return ans;
//        int i = 0;
//        for (; i < num.length(); i++)
//            if (num.charAt(i) != '0') break;
//        num = num.substring(i, num.length());
        dfs(num, 0);
        return ans;
    }

    private void dfs(String num, int start) {
        if (start >= num.length()) {
            if (path.size() > 2 ) {
                ans = new ArrayList<>(path);
            }
            return;
        }

        for (int i = start + 1; i <= num.length(); i++) {
            long x = Long.parseLong(num.substring(start, i));
            if (String.valueOf(x).length() < i - start || x > Integer.MAX_VALUE) break;
            if (path.size() >= 2 && path.getLast() + path.get(path.size() - 2) != x) continue;
            path.add((int) x);
            dfs(num, i);
            path.removeLast();
        }
    }
}

class Test27 {
    public static void main(String[] args) {
        将数组拆分成斐波那契序列842 test = new 将数组拆分成斐波那契序列842();
        test.splitIntoFibonacci("1101111");
        test.splitIntoFibonacci("1101111");
    }

}