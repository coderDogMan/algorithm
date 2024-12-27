package week.week.year2024firstQuarter;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 销售价值减少的颜色球1648 {
    int MOD = (int) 1e9 +7;

    public int maxProfit(int[] inventory, int orders) {
        long ans = 0;
        int n = inventory.length;
        Arrays.sort(inventory);
        int l = 0, r = (int) 1e9;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, inventory, orders)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));

        for (int i = n - 1; i >= 0 && orders > 0; i--) {
            if (inventory[i] - l < 0) break;
            orders -= (inventory[i] - l);
            if (orders < 0) {
                orders += (inventory[i] - l);
                break;
            }
            q.add(l);
            ans = (ans + sum(inventory[i], l)) % MOD;
        }
        while (orders > 0) {
            orders--;
            Integer poll = q.poll();
            ans = (ans + poll) % MOD;
            q.add(poll - 1);
        }
        return (int) ans;
    }

    private long sum(long r, long l) {
        return ((r + 1) * r - (l + 1) * l) / 2 % MOD;
    }

    private boolean check(int mid, int[] inventory, int t) {
        long res = 0;
        for (int i = inventory.length - 1; i >= 0; i--) {
            if (inventory[i] < mid) break;
            res += inventory[i] - mid;
        }
        return res >= t;
    }

}

class Test32 {
    public static void main(String[] args) {
        销售价值减少的颜色球1648 test = new 销售价值减少的颜色球1648();
        test.maxProfit(new int[]{497978859,167261111,483575207,591815159}, 836556809);
        test.maxProfit(new int[]{1000000000}, 1000000000);
        test.maxProfit(new int[]{2,5}, 4);
    }
}
