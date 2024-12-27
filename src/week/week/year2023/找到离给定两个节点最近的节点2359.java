package week.week.year2023;

import java.util.LinkedList;

public class 找到离给定两个节点最近的节点2359 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2) return node1;
        int n = edges.length;
        int[] vis = new int[n];
        LinkedList<Integer> queue1 = new LinkedList<>();
        LinkedList<Integer> queue2 = new LinkedList<>();
        queue1.add(node1);
        queue2.add(node2);
        vis[node1] = 1;
        vis[node2] = 2;
        int ans1 = -1;
        int ans2 = -1;
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                Integer node = queue1.poll();
                int next = edges[node];
                if (next != -1 && vis[next] == 2) {
                    ans1 = next;
                } else if (next != -1 && vis[next] == 0) {
                    queue1.add(next);
                    vis[next] = 1;
                }
            }

            if (!queue2.isEmpty()) {
                Integer node = queue2.poll();
                int next = edges[node];
                if (next != -1 && vis[next] == 1) {
                    ans2 = next;
                } else if (next != -1 && vis[next] == 0) {
                    queue2.add(next);
                    vis[next] = 2;
                }
            }
            if (ans1 != -1 && ans2 != -1) {
                return Math.min(ans1, ans2);
            } else if (ans1 != -1) {
                return ans1;
            } else if (ans2 != -1) {
                return ans2;
            }
        }
        return -1;
    }
}

class Test13 {
    public static void main(String[] args) {
        找到离给定两个节点最近的节点2359 test = new 找到离给定两个节点最近的节点2359();
//        test.closestMeetingNode(new int[]{5,3,1,0,2,4,5}, 3, 2);
        test.closestMeetingNode(new int[]{4,4,8,-1,9,8,4,4,1,1}, 5, 6);
    }
}
