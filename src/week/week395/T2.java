package week.week395;

import java.util.Arrays;
import java.util.HashMap;

public class T2 {

    HashMap<Integer, Integer> map2;
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int m = nums2.length;
        Arrays.sort(nums1);
        map2 = new HashMap<>();
        for (int i = 0; i < m; i++) map2.merge(nums2[i], 1, Integer::sum);
        for (int x = -1000; x <= 1000; x++) {
            HashMap<Integer, Integer> map1 = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) map1.merge(nums1[i] + x, 1, Integer::sum);
            boolean flag = true;
            for (Integer key2 : map2.keySet()) {
                if (!map1.containsKey(key2)) {
                    flag = false;
                    break;
                }
                if (map1.get(key2) < map2.get(key2)) flag = false;
            }
            if (flag) return x;
        }
        return -10000;
    }
}

class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.minimumAddedInteger(new int[]{4,20,16,12,8}, new int[]{14,18,10});
    }
}
