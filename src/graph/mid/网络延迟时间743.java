package graph.mid;

public class 网络延迟时间743 {
    int[][] graph;
    int n;
    public int networkDelayTime(int[][] times, int n, int k) {
        this.n = n;
        graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j<= n;j++) {
                graph[i][j] = i == j ? 0 : Integer.MAX_VALUE / 2;
            }
        }
        for (int[] edge : times)
            graph[edge[0]][edge[1]] = edge[2];
        floyd();
        int ans = 0;
        for (int i = 1; i <= n; i++)
            ans = Math.max(ans, graph[k][i]);
        return ans >= Integer.MAX_VALUE / 2 ? -1 : ans;
    }

    public void floyd() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }
}

class Test {
    public static void main(String[] args) {
        网络延迟时间743 test = new 网络延迟时间743();
        test.networkDelayTime(new int[][]{
                {2,1,1},{2,3,1},{3,4,1}
        }, 4,2);
    }
}
