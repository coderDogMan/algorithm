package week.week359;

import java.util.*;

public class Q3 {

    LinkedList<int[]>[] map;
    int[] memo;
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        map = new LinkedList[n];
        Arrays.setAll(map, e -> new LinkedList());
        for (List<Integer> offer : offers) {
            int start = offer.get(0);
            int end = offer.get(1);
            int g = offer.get(2);
            map[end].add(new int[]{start, g});
        }
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(n - 1);
    }

    private int dfs(int i) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];
        int res = 0;
        LinkedList<int[]> cur = map[i];
        res = dfs(i - 1);
        for (int[] val : cur) {
            res = Math.max(res, dfs(val[0] - 1) + val[1]);
        }
        memo[i] = res;
        return res;
    }
}

class Test3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        List<List<Integer>> in = new LinkedList<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();
        list1.add(0);
        list1.add(0);
        list1.add(1);

        list2.add(0);
        list2.add(2);
        list2.add(2);

        list3.add(1);
        list3.add(3);
        list3.add(2);

        in.add(list1);
        in.add(list2);
        in.add(list3);
        q3.maximizeTheProfit(5,in);
    }
}