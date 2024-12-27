package writtentest.szml;

import java.util.HashMap;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap();
        int[] W = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            W[i] = x;
            if (x <= m) {
                map.merge(x, 1, Integer::sum);
                ans = Math.max(ans, map.get(x));
            }
        }
        System.out.println(ans);
    }
}
