package writtentest.roubao.weektwo112;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T5 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();
        int[] perSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            perSum[i + 1] = perSum[i] + (nums.get(i) % modulo == k ? 1 : 0);
        }
        // (perSum[R + 1] - perSum[L]) % m = k
        // perSum[R + 1] % m - perSum[L] % m = k
        // (perSum[R + 1] - k + m) % m  = perSum[L] % m
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= n; i++) {
            int x = (perSum[i] - k + modulo) % modulo;
            if (map.containsKey(x)) {
                ans += map.get(x);
            }
            map.put(perSum[i] % modulo, map.getOrDefault(perSum[i] % modulo, 0) + 1);

        }
        return ans;
    }
}

class Test5 {
    public static void main(String[] args) {
        T5 t5 = new T5();
        LinkedList<Integer> list = new LinkedList<>();
//        list.add(3);
//        list.add(2);
//        list.add(4);

//
//        list.add(3);
//        list.add(1);
//        list.add(9);
//        list.add(6);


        list.add(5);
        list.add(1);



//        list.add(11);
//        list.add(12);
//        list.add(21);
//        list.add(31);


        System.out.println(t5.countInterestingSubarrays(list, 6, 1));
//        System.out.println(t5.countInterestingSubarrays(list, 10, 1));


    }
}