package niuke.test4;

import java.util.HashMap;
import java.util.Scanner;

public class T6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int left = 0;
        int size = k * 2 + 1;
        //蓝牙看见的 - 1
        for (; i < k && i < n; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        //滑动窗口
        for (; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i - left + 1 > size) {
                int key = nums[left];
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
                left++;
            }
            int ans = 0;
            for (Integer key : map.keySet()) {
                if ((map.get(key) & 1) == 1)
                    ans = Math.max(ans, key);
            }
            System.out.println(ans);
        }
        //处理草太看见的 k次
        for (i = 0; i < k; i++) {
            int key1 = nums[left];
            if (map.get(key1) == 1) {
                map.remove(key1);
            } else {
                map.put(key1, map.get(key1) - 1);
            }
            left++;
            int ans = 0;
            for (Integer key : map.keySet()) {
                if ((map.get(key) & 1) == 1)
                    ans = Math.max(ans, key);
            }
            System.out.println(ans);
        }

    }
}
