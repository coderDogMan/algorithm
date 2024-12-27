package week.week.year2023;

public class 找到冠军II2924 {
    public int findChampion(int n, int[][] edges) {
        int[] inEdge = new int[n];
        for (int[] edge : edges) {
            inEdge[edge[1]]++;
        }
        int ans = -1;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (inEdge[i] == 0) {
                num++;
                ans = i;
            }
        }
        return num == 1 ? ans : -1;
    }
}
