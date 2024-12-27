package writtentest.oppo2023;

import java.util.HashMap;
import java.util.Scanner;

public class 组装手机 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = in.nextInt();
            mapA.put(key, mapA.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int key = in.nextInt();
            mapB.put(key, mapB.getOrDefault(key, 0) + 1);
        }
        int ans = 0;
        for (int power = 2; power <= 2000; power++) {
            int num = 0;
            for (Integer keyA : mapA.keySet()) {
                num += Math.min(mapA.get(keyA), mapB.getOrDefault(power - keyA, 0));
            }
            ans = Math.max(ans, num);
        }
        System.out.println(ans);




    }
}
