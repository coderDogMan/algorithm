package week.ccfa;


import java.util.LinkedList;
import java.util.Scanner;

public class A {
    static int n, m, k;
    static int mp[][]; // 1围墙 2yj
    static LinkedList<int[]> q;
    static int dfn[][] = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        q = new LinkedList<>();
        n = in.nextInt(); m = in.nextInt(); k = in.nextInt();
        mp = new int[n + 10][m + 10];
        for(int i = 1; i <= k; i ++){
            int x1, y1, x2, y2;
            x1 = in.nextInt(); y1 = in.nextInt(); x2 = in.nextInt(); y2 = in.nextInt();
            if(x1 == x2){
                for(int j = Math.min(y1, y2); j <= Math.max(y1, y2); j ++)
                    mp[x1][j] = 1;
            }else{
                for(int j = Math.min(x1, x2); j <= Math.max(x1, x2); j ++)
                    mp[j][y1] = 1;
            }
        }
        int xs = in.nextInt(), ys = in.nextInt();
        q.add(new int[]{xs, ys});
        mp[xs][ys] = 2;
        bfs();
    }
    public static boolean isBord(int x, int y){
        return x > 0 && x <= n && y > 0 && y <= m;
    }
    public static void bfs(){
        boolean wall = true;
        LinkedList<int[]> arr = new LinkedList<>();
        while(q.size() > 0){
            int[] now = q.poll();
            for(int i = 0; i < 4; i ++){
                int xs = dfn[i][0] + now[0], ys = dfn[i][1] + now[1];
                if(!isBord(xs, ys)){
                    wall = false;
                    continue;
                }
                if(mp[xs][ys] == 2) {
                    continue;
                }
                if (mp[xs][ys] == 1 ) {
                    arr.add(new int[]{xs, ys});
                    mp[xs][ys] = 2;
                } else {
                    q.add(new int[]{xs, ys});
                    mp[xs][ys] = 2;
                }

            }

            if(q.size() == 0 && wall){
                LinkedList<int[]> sx = q;
                q = arr;
                arr = sx;
            }
        }
        int ans = 0;
        for(int i = 1; i <= n; i ++){
            for(int j = 1; j <= m; j ++){
                if(mp[i][j] == 0){
                    ans ++;
                }
            }
        }
        System.out.println(ans);
    }
}
