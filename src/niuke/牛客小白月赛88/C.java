package niuke.牛客小白月赛88;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int h = in.nextInt();
            int m = in.nextInt();
            int cur = h * 60 + m;
            set.add(cur - 1);
            set.add(cur - 3);
            set.add(cur - 5);
        }
        int[] times = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(times);
        System.out.println(times.length);
        for (int i = 0; i < times.length; i++) {
            System.out.println(times[i] / 60 + " " + times[i] % 60);
        }
    }
}
