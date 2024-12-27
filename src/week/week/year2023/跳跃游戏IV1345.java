package week.week.year2023;

import java.util.HashMap;
import java.util.LinkedList;

public class 跳跃游戏IV1345 {

    public int minJumps(int[] arr) {
        int n = arr.length;
        boolean[] vis = new boolean[n];
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = arr[i];
            if (map.containsKey(x)) {
                map.get(x).add(i);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(i);
                map.put(x, list);
            }
        }
        // 下标
        LinkedList<Integer> queue = new LinkedList<>();
        vis[0] = true;
        queue.add(0);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer cur = queue.poll();
                if (cur == n - 1) {
                    return ans;
                }
                if (cur - 1 >= 0 && !vis[cur - 1]) {
                    queue.add(cur - 1);
                    vis[cur - 1] = true;
                }
                if (cur + 1 < n && !vis[cur + 1]) {
                    queue.add(cur + 1);
                    vis[cur + 1] = true;
                }
                if (map.containsKey(arr[cur])) {
                    for (Integer idx : map.get(arr[cur])) {
                        if (idx == cur) continue;
                        if (!vis[idx]) {
                            queue.add(idx);
                            vis[idx] = true;
                        }
                    }
                    map.remove(arr[cur]);
                }

            }
            ans++;
        }


        return -1;
    }

}

class Test67 {
    public static void main(String[] args) {
        跳跃游戏IV1345 test = new 跳跃游戏IV1345();
        test.minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404});
    }
}