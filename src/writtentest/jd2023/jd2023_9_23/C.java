package writtentest.jd2023.jd2023_9_23;

import java.util.Arrays;
import java.util.Scanner;
import java.util.WeakHashMap;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] J = new int[n / 2][2];
        int[][] O = new int[n - n / 2][2];
        int idxO = 0;
        int idxJ = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                O[idxO][0] = in.nextInt();
                O[idxO][1] = idxO++;
            } else {
                J[idxJ][0] = in.nextInt();
                J[idxJ][1] = idxJ++;
            }
        }
        int last = -1;
        Arrays.sort(O, (a, b) -> (a[0] - b[0]));
        Arrays.sort(J, (a, b) -> (a[0] - b[0]));
        int i = 0;
        int ans = 0;
        while (i < n / 2) {
            if (J[i][0] > O[i][0] && O[i][0] > last) {
                if (O[i][1] != i) ans++;
                if (J[i][1] != i) ans++;
                last = O[i][0];
            } else {
                System.out.println(-1);
                return;
            }
            i++;
        }
        if (i < O.length) {
            if (O[i][0] < J[i - 1][0]) {
                System.out.println(-1);
                return;
            }
        }
        if (i != O[i][1]) ans++;
        System.out.println(ans / 2);

    }
}
