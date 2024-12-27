package week.week.year2023;

import java.util.ArrayList;
import java.util.HashMap;

public class 相同元素的间隔之和2121 {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        long[] ans = new long[n];
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (hashMap.get(arr[i]) == null) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(arr[i], list);
            } else {
                hashMap.get(arr[i]).add(i);
            }
        }
        for (Integer key : hashMap.keySet()) {
            ArrayList<Integer> list = hashMap.get(key);
            long[] L = new long[list.size()];
            long[] R = new long[list.size()];
            for (int i = 1; i < list.size(); i++) {
                L[i] = (list.get(i) - list.get(i - 1)) * (long)i + L[i - 1];
            }
            for (int i = list.size() - 2; i >= 0; i--) {
                R[i] = (list.get(i + 1) - list.get(i)) * (list.size() - i - 1) + R[i + 1];
            }
            for (int i = 0; i < list.size(); i++) {
                ans[list.get(i)] = L[i] + R[i];
            }
        }
        return ans;
    }
}

class Test22 {
    public static void main(String[] args) {
        相同元素的间隔之和2121 test = new 相同元素的间隔之和2121();
        test.getDistances(new int[]{2,1,3,1,2,3,3});
    }
}
