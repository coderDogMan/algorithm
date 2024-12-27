package niuke.test4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class T3 {

    private final static int MAX = 32000;
    private final static int[] primes = new int[3500];

    public static void init() {
        boolean[] used = new boolean[MAX + 1];
        int index = 1;
        for (int i= 2; i <= MAX; i++) {
            if (!used[i]) {
                primes[index++] = i;
                for (int j = i; j * i <= MAX; j++) {
                    used[j * i] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        init();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i < primes.length; i++) {
            if (primes[i] == 0 || primes[i] < 0) break;
            set.add(primes[i] *  primes[i]);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (set.contains(num)) {
                ans = Math.max(ans, num);
            }
        }
        System.out.println(ans);
    }
}
