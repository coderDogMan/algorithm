package week.week.year2023;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class 概率最大的路径1514 {

    int n;
    int start_node;
    double[] succProb;
    LinkedList<Pair<Integer, Double>>[] g;
    double[] dist;
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        this.n = n;
        this.succProb = succProb;
        this.start_node = start_node;
        g = new LinkedList[n];
        for (int i = 0; i < n; i++)
            g[i] = new LinkedList();
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];
            g[u].add(new Pair<>(v, w));
            g[v].add(new Pair<>(u, w));
        }
        dist = new double[n];
        dijkstra();
        return dist[end_node];
    }

    private void dijkstra() {
        boolean[] vis = new boolean[n];
        PriorityQueue<Pair<Integer, Double>> queue = new PriorityQueue<>((a, b) -> {
            return b.getValue().compareTo(a.getValue());
        });
        queue.add(new Pair(start_node, 1.0));
        while (!queue.isEmpty()) {
            Pair<Integer, Double> node = queue.poll();
            int id = node.getKey();
            Double step = node.getValue();
            if (vis[id]) continue;
            vis[id] = true;
            for (Pair<Integer, Double> son : g[id]) {
                if (!vis[son.getKey()] && step * son.getValue() > dist[son.getKey()]) {
                    dist[son.getKey()] = step * son.getValue();
                    queue.add(new Pair<>(son.getKey(), step * son.getValue()));
                }
            }
        }
    }
}

class Test79 {
    public static void main(String[] args) {
        概率最大的路径1514 test = new 概率最大的路径1514();
        test.maxProbability(5, new int[][]{{1,4}, {2, 4},{0, 4}, {0, 3}, {0, 2}, {2, 3}}, new double[]{0.37,0.17,0.93,0.23,0.39,0.04}, 3, 4);
    }
}
