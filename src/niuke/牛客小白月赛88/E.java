package niuke.牛客小白月赛88;

import java.util.HashMap;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            int[][] op = new int[m][2];
            for (int i = 0; i < m; i++) op[i] = new int[] {in.nextInt(), in.nextInt()};
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = m - 1; i >= 0; i--) {
                if (map.containsKey(op[i][1]))
                    map.put(op[i][0], map.get(op[i][1]));
                else
                    map.put(op[i][0], op[i][1]);
            }
            for (int num : nums) {
                System.out.print(map.getOrDefault(num, num) + " ");
            }
            System.out.println();


        }



    }
}
