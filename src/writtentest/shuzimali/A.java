package writtentest.shuzimali;

import java.util.LinkedList;
import java.util.Scanner;

public class A {
    static int n;
    static int m;
    static LinkedList<Integer> path;
    public static void main(String[] args) {
        new Thread();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        path = new LinkedList<>();
        dfs(1, 0);
    }

    private static void dfs(int i, int sum) {
        if (sum == m) {
            for (Integer num : path) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        if (i > n || sum > m) {
            return;
        }
        path.add(i);
        dfs(i + 1, sum + i);
        path.pollLast();
        dfs(i + 1, sum);

    }
}
