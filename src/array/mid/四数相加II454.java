package array.mid;

import java.util.HashMap;
import java.util.Set;

public class 四数相加II454 {
    public static void main(String[] args) {
//        System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        System.out.println(fourSumCount(new int[]{-1,-1}, new int[]{-1,1}, new int[]{-1,1}, new int[]{1,-1}));
    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (!hashMap1.containsKey(nums1[i] + nums2[j])) {
                    hashMap1.put(nums1[i] + nums2[j], 1);
                } else {
                    hashMap1.put(nums1[i] + nums2[j], hashMap1.get(nums1[i] + nums2[j]) + 1);
                }
            }
        }
        int res = 0;

        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                if (hashMap1.containsKey(0 - (nums3[i] + nums4[j]))) {
                    res += hashMap1.get(0 - (nums3[i] + nums4[j]));
                }
            }
        }

        return res;
    }
}
