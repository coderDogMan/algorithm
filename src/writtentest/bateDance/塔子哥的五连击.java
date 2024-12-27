package writtentest.bateDance;

import java.util.Scanner;
import java.util.TreeMap;

public class 塔子哥的五连击 {
    static long min = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // map[A B C D][]
        TreeMap<Integer, Long>[] map = new TreeMap[4];
        for (int i = 0; i < 4; i++) {
            map[i] = new TreeMap<>();
        }
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            Long b = Long.valueOf(in.nextInt());
            int c = in.next().charAt(0) - 'A';
            TreeMap<Integer, Long> treeMap = map[c];
            if (treeMap.containsKey(a)) {
                treeMap.put(a, treeMap.get(a) + b);
            } else {
                treeMap.put(a, b);
            }
        }
        long ans = 0;

        for (int i = 0; i < 4; i++) {
            TreeMap<Integer, Long> treeMap = map[i];
            int[] keys = treeMap.keySet().stream().mapToInt(Integer::intValue).toArray();
            for (int j = 0; j <= keys.length - 5; j++) {
                if (!check(treeMap, keys, j)) continue;
                ans += min;
                for (int start = j; start < j + 5; start++) {
                    treeMap.put(keys[start], treeMap.get(keys[start]) - min);
                }
            }
        }
        System.out.println(ans);

    }

    private static boolean check(TreeMap<Integer, Long> treeMap, int[] keys, int j) {
        min = treeMap.get(keys[j]);
        for (int i = j; i < j + 4 && i < keys.length - 1; i++) {
            if (keys[i + 1] - 1 != keys[i]) return false;
            min = Math.min(min, treeMap.get(keys[i + 1]));
        }
        return true;
    }
}
