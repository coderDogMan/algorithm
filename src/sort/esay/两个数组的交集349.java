package sort.esay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 两个数组的交集349 {
    public static void main(String[] args) {
        int[] intersection = intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(intersection);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1)
            set.add(i);
        int[] arr1 = new int[nums2.length];
        int cur = 0;
        for (int i : nums2)
            if (set.contains(i)) {
                arr1[cur++] = i;
                set.remove(i);
            }
        int[] arr2 = new int[cur];
        for (int i = 0; i < cur; i++)
            arr2[i] = arr1[i];

        return arr2;
    }
}
