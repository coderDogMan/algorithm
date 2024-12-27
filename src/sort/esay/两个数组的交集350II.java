package sort.esay;

import java.util.ArrayList;
import java.util.HashMap;

public class 两个数组的交集350II {
    public static void main(String[] args) {
        int[] intersect = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(intersect);

    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums1) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : nums2) {
            if (hashMap.containsKey(i) &&  hashMap.get(i) != 0) {
                list.add(i);
                hashMap.put(i, hashMap.get(i) - 1);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}
