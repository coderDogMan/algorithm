package writtentest.pdd2023;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

//public class 投喂珍珠 {
//    static int square = 0;
//    static int food;
//    static int m;
//    static int[] dit;
//    static boolean[] used;
//    static ArrayList<Integer>[] edge;
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        m = in.nextInt();
//        dit = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            dit[i] = in.nextInt();
//        }
//        used = new boolean[n + 1];
//        edge = new ArrayList[n + 1];
//        for (int i = 0; i <= n; i++)
//            edge[i] = new ArrayList<>();
//        for (int i = 1; i < n; i++) {
//            int u = in.nextInt();
//            int v = in.nextInt();
//            edge[u].add(v);
//            edge[v].add(u);
//        }
//        dfs(1, dit[1], 1);
//        System.out.println(square + " " + food);
//    }
//    //                          节点      权值      深度
//    private static void dfs(int root, int use, int deep) {
//        if (use > m) {
//            return;
//        } else if (use == m) {
//            if (square < deep) {
//                food = use;
//                square = deep;
//            }
//            return;
//        }
//        if (square < deep) {
//            food = use;
//            square = deep;
//        }
//        used[root] = true;
//        for (Integer son : edge[root]) {
//            if (!used[son]) {
//                dfs(son, use + dit[son], deep + 1);
//            }
//        }
//
//    }
//}



public class 投喂珍珠 {
    static int[] dit;
    static LinkedList<Integer>[] edge;
    static int gNum = 0;
    static int mNUm = 0;
    static int m;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        m = in.nextInt();
        dit = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dit[i] = in.nextInt();
        }
        edge = new LinkedList[n + 1];
        for (int i = 0; i <= n; i++) {
            edge[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            edge[u].add(v);
            edge[v].add(u);
        }
        // 当前节点 fa 广场数量， 码粮使用情况
        dfs(1, -1, 0, 0);
        System.out.println(gNum + " " + mNUm);
    }

    private static void dfs(int cur, int fa, int num, int ml) {
        ml += dit[cur];
        num++;
        if (ml > m) return;

        if (num > gNum) {
            gNum = num;
            mNUm = ml;
        } else if (num == gNum) {
            mNUm = Math.min(mNUm, ml);
        }
        for (Integer son : edge[cur]) {
            if (son == fa) continue;
            dfs(son, cur, num, ml);
        }
    }
}
