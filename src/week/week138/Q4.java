package week.week138;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Q4 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        Set<Integer> ids = map.keySet();
        int n = ids.size();
        Integer[] keys = new Integer[n];
        int idx = 0;
        for (Integer id : ids) {
            keys[idx++] = id;
        }
        Arrays.sort(keys, (a, b) -> (map.get(b) - map.get(a)));
        idx = 0;
        int[] ans = new int[barcodes.length];
        for (int i = 0; i < ans.length; i += 2) {
            if (map.get(keys[idx]) == 0) {
                idx++;
                i -= 2;
            } else {
                ans[i] = keys[idx];
                map.put(keys[idx], map.get(keys[idx]) - 1);
            }
        }
        for (int i = 1; i < ans.length; i += 2) {
            if (map.get(keys[idx]) == 0) {
                idx++;
                i -= 2;
            } else {
                ans[i] = keys[idx];
                map.put(keys[idx], map.get(keys[idx]) - 1);
            }
        }
        return ans;
    }
}

class Test4 {
    public static void main(String[] args) {
        Q4 q4 = new Q4();
        q4.rearrangeBarcodes(new int[]{1,1,1,2,2,2});
    }

}
