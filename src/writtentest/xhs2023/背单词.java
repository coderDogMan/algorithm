package writtentest.xhs2023;

import java.util.HashMap;
import java.util.Scanner;

public class 背单词 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String s = in.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (map.get(s) > ans) {
                ans++;
                map.put(s, Integer.MIN_VALUE);
            }
        }

        System.out.println(ans);

    }
}
