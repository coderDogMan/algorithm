package writtentest.roubao.weektwo112;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class T3 {

    public long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        long ans = 0;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            Integer key = nums.get(i);
            sum += key;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        if (map.size() >= m) ans = sum;

        int l = 0;
        for (int i = k; i < n; i++) {
            Integer num = nums.get(l);
            sum -= num;
            if (map.get(num) == 1) {
                map.remove(num);
            } else {
                map.put(num, map.get(num) - 1);
            }
            l++;
            num = nums.get(i);
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.size() >= m) ans = Math.max(ans, sum);
        }
        return ans;
    }
}
class Test3 {
    public static void main(String[] args) {
        T3 q3 = new T3();
        List<Integer> list = new LinkedList<>();
//        list.add(2);
//        list.add(6);
//        list.add(7);
//        list.add(3);
//        list.add(1);
//        list.add(7);

//        list.add(5);
//        list.add(9);
//        list.add(9);
//        list.add(2);
//        list.add(4);
//        list.add(5);
//        list.add(4);

        list.add(1);
        list.add(1);
        list.add(1);
        list.add(3);

        q3.maxSum(list, 2, 2);

    }
}
