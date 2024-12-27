package week.week.year2024firstQuarter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class 公交路线815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        LinkedList<Integer> q = new LinkedList<>();
        //一个车对应的车站
        HashMap<Integer, HashSet<Integer>> carMap = new HashMap<>();
        //一个车站对应的的车
        HashMap<Integer, HashSet<Integer>> nodeMap = new HashMap<>();
        // 访问过的车
        HashSet<Integer> visCar = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int node : routes[i]) {
                if (node == source) {
                    q.add(i);
                    visCar.add(i);
                }
                HashSet<Integer> nset = nodeMap.getOrDefault(node, new HashSet<>());
                nset.add(i);
                nodeMap.put(node, nset);

                HashSet<Integer> set = carMap.getOrDefault(i, new HashSet<>());
                set.add(node);
                carMap.put(i, set);
            }
        }
        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Integer car = q.poll();
                for (Integer node : carMap.get(car)){
                    if (node == target) return ans;
                    for (Integer c : nodeMap.get(node)) {
                        if (!visCar.contains(c)) {
                            q.add(c);
                            visCar.add(c);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
class Test24 {
    public static void main(String[] args) {
        公交路线815 test = new 公交路线815();
        test.numBusesToDestination(new int[][]{{1,2,7}, {3,6,7}}, 1, 6);
    }
}
