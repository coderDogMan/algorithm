package niuke.test122;

import java.util.HashMap;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int i = 0; i < n; i++) b[i] = in.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (map.containsKey(a[i]) && map.get(a[i]) != b[i]) {
                    System.out.println("No");
                    break;
                } else {
                    map.put(a[i], b[i]);
                    if (i == n - 1) {
                        System.out.println("Yes");
                    }
                }

            }

        }


    }

}
