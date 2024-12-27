package week.week379;

import java.util.HashSet;

public class T3 {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        int n = nums1.length;
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        int num1 = 0;
        int num2 = 0;
        HashSet<Integer> vis1 = new HashSet<>();
        HashSet<Integer> vis2 = new HashSet<>();
        for (int num : nums1) {
            if (!set2.contains(num) && !vis1.contains(num)) {
                num1++;
                vis1.add(num);
            }
            if (num1 == n / 2) break;
        }
        for (int num : nums2) {
            if (!set1.contains(num) && !vis2.contains(num)) {
                num2++;
                vis2.add(num);
            }
            if (num2 == n / 2) break;
        }
        int j = 0;
        for (Integer k : set1) {
            if (set2.contains(k)) j++;
        }
        if (num1 < n / 2 && num2 < n / 2) {
            return num1 + num2 + Math.min(n - num1 - num2, j);
        } else if (num1 < n / 2) {
            return num1 + num2 + Math.min(n / 2 - num1 , j);
        } else if (num2 < n / 2) {
            return num1 + num2 + Math.min(n / 2 - num2 , j);
        }
        return num1 + num2;
    }
}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.maximumSetSize(new int[]{1,2,1,2}, new int[]{1,1,1,1});
    }
}