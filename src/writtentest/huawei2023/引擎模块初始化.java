package writtentest.huawei2023;

import java.util.LinkedList;
import java.util.Scanner;

public class 引擎模块初始化 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        LinkedList<Integer>[] edge = new LinkedList[n + 1];
        int[] inEdge = new int[n + 1];
        int sum = 0;
        for (int i = 0; i <= n; i++) edge[i] = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            int num = in.nextInt();
            for (int j = 0 ; j < num; j++) {
                edge[in.nextInt()].add(i);
                inEdge[i]++;
                sum++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inEdge[i] == 0) queue.add(i);
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int fa = queue.poll();
                LinkedList<Integer> son = edge[fa];
                for (int j = 0; j < son.size(); j++) {
                    inEdge[son.get(j)]--;
                    sum--;
                    if (inEdge[son.get(j)] == 0) {
                        queue.add(son.get(j));
                    }
                }
            }
            ans++;
        }
        System.out.println(sum == 0 ? ans : -1);
    }
}
