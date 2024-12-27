package week.gsdc.test8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++)
            map.put(i, i - 1);
        while (m-- > 0) {
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            int idx1 = map.get(num1);
            int idx2 = map.get(num2);
            map.put(num2, idx1);
            map.put(num1, idx2);
        }
        int[] ans = new int[n];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans[entry.getValue()] = entry.getKey();
        }
        for (int i= 0; i < n; i++)
            System.out.print(ans[i] + " ");

    }

}
