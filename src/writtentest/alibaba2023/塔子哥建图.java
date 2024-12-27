package writtentest.alibaba2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 塔子哥建图 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        if (n == 2) {
            System.out.println(1);
        } else if (map.size() == 1) {
            for (Integer value : map.values()) {
                System.out.println((value) * (value - 1) / 2 );
            }
        } else {
            long ans = 0;
            int curNum = 0;

            for (Integer num : map.values()) {
                if (curNum + num == 2) {
                    ans += 1;
                } else if (curNum + num > 2){
                    ans += (num + 1 + 2) * num / 2;
                }
                curNum += num;
            }

            System.out.println(ans);
        }


    }
}
