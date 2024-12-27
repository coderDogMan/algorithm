package week.week345;

import java.util.LinkedList;

public class T1 {
    public int[] circularGameLosers(int n, int k) {
        int[] nums = new int[n];
        int max = 0;
        int num = 0;
        int idx = 0;
        while (max < 2) {
            nums[(idx + num * k) % n]++;
            if (nums[(idx + num * k) % n] > max) {
                max = nums[(idx + num * k) % n];
            }
            idx = idx + num * k;
            num++;
        }
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) ans.add(i + 1);
        }
        return ans.stream().mapToInt(Integer::valueOf).toArray();

    }
}

class Test1 {
    public static void main(String[] args) {
        T1 test = new T1();
        test.circularGameLosers(5, 2);
    }
}
