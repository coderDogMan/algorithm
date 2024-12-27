package week.week.year2023;

import java.util.ArrayList;
import java.util.HashMap;

public class 区间内查询数字的频率2080 {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public 区间内查询数字的频率2080(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
    }

    public int query(int left, int right, int value) {
        ArrayList<Integer> list = map.get(value);
        if (list == null) return 0;
        int l = find(list, left);
        int r = find(list, right + 1) - 1;
        return r - l + 1;
    }

    //找到第一个大于等于 val 的
    private int find(ArrayList<Integer> list, int val) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}

class Test5 {
    public static void main(String[] args) {
        区间内查询数字的频率2080 test = new 区间内查询数字的频率2080(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(test.query(1, 2, 4));
        System.out.println(test.query(0, 11, 33));
    }
}