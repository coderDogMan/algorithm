package acwing.mid;

import java.util.ArrayList;
import java.util.Scanner;

public class 数字游戏 {

    static int N = 35;
    //i j  j开头，长度i
    static int[][] f = new int[N][N];


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        init();
        System.out.println(dp(b) - dp(a - 1));

    }

    private static int dp(int n) {
        if(n == 0) return 1;

        ArrayList<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add(n%10);
            n/=10;
        }
        int res=0;//方案数
        int last=0;//保留一些前缀信息，本题是上一个数是几
        ///从最大数开始枚举
        for(int i=list.size()-1;i>=0;i--)
        {
            int x=list.get(i);//x为当前这位数
            for(int j=last;j<x;j++)
            res+=f[i+1][j];    ///左端的节点有i+1个位数（因为第一位的下标是0)

            if(x<last) break;//如果当前这位数比上一位小，那么后面的都不成立了，直接break退出

            last=x;

            if(i == 0) res++; //如果能顺利到最后一个数说明树的最右边这一段的每一个数都是小于等于前一位数的，因而++
        }

        return res;
    }

    private static void init() {
        for (int i = 1; i <= 9; i++) f[1][i] = 1;
        for (int i = 2; i < N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <= 9; k++) {
                    f[i][j] += f[i - 1][k];
                }
            }
        }
    }
}
