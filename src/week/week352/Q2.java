package week.week352;

import week.week138.Q4;

import java.util.*;

public class Q2 {
    static int MAX = (int) 1e6;
    static boolean[] vis = new boolean[MAX + 1];
    static boolean[] primes = new boolean[MAX + 1];
    static {
        for (int i = 2; i < MAX; i++) {
            if (vis[i]) continue;
            primes[i] = true;
            for (int j = i; j <= MAX / i; j++) {
                vis[j * i] = true;
            }
        }
    }

    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 3) return ans;
        Arrays.fill(vis, false);
        for (int i = 2; i < n - 1; i++) {
            if (primes[i] && primes[n - i] && !vis[i]) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                list.add(n - i);
                ans.add(list);
                vis[i] = true;
                vis[n - i] = true;
            }
        }
        return ans;
    }
}

class Test2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        q2.findPrimePairs(167);
        q2.findPrimePairs(167);
        q2.findPrimePairs(236);
        q2.findPrimePairs(10);
    }
}