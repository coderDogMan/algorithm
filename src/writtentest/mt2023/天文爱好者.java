package writtentest.mt2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 天文爱好者 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0 ; i < n; i++) {
            start[i] = in.nextInt();
        }
        for (int i = 0 ; i < n; i++) {
            end[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            map.put(start[i], map.getOrDefault(start[i], 0) + 1);
            map.put(end[i] + 1, map.getOrDefault(end[i] + 1, 0) - 1);
        }
        int[] keys = map.keySet().stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(keys);
        int max = 0;
        int ans = 0;
        int temp = 0;

        for (int i = 0; i < keys.length; i++) {
            temp += map.get(keys[i]);
            if (temp > max) {
                ans = keys[i + 1] - keys[i];
                max = temp;
            } else if (temp == max) {
                ans += keys[i + 1] - keys[i];
            }
        }
        System.out.println(max + " " + ans);
    }
}
