package week.week.year2023;

import java.util.*;

public class 获取你好友已观看的视频1311 {
    LinkedList<Integer>[] edge;
    HashSet<Integer> set = new HashSet<>();
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        edge = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++)
            edge[i] = new LinkedList();
        for (int i = 0; i < n; i++) {
            for (int friend : friends[i]) {
                edge[i].add(friend);
            }
        }
        boolean[] vis = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(id);
        vis[id] = true;
        while (level-- > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer fa = queue.poll();
                for (Integer son : edge[fa]) {
                    if (vis[son]) continue;
                    queue.add(son);
                    vis[son] = true;
                }
            }
        }
        for (Integer integer : queue) {
            System.out.println(integer);
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (Integer idx : queue) {
            for (String s : watchedVideos.get(idx)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> {
            if (a.getValue() == b.getValue()) {
                return a.getKey().compareTo(b.getKey());
            }

            return a.getValue() - b.getValue();
        });
        LinkedList<String> ans = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : list) {
            ans.add(entry.getKey());
        }
        return ans;
    }


}

class Test1 {
    public static void main(String[] args) {
        获取你好友已观看的视频1311 test = new 获取你好友已观看的视频1311();
        List<List> list = new ArrayList<>();

    }
}
