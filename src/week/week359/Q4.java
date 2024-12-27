package week.week359;

import java.util.*;
import java.util.stream.Collectors;

public class Q4 {

    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            if (map.containsKey(x)) map.get(x).add(i);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(x, list);
            }
        }
        int ans = 1;
        // list 下标
        for (ArrayList<Integer> list : map.values()) {
            int len = 1;
            int l = 0;
            for (int i = 1; i < list.size(); i++) {
                while (l < list.size() && list.get(i) - list.get(l) - (i - l) > k) {
                    l++;
                }
                len = i - l + 1;
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
class Test4 {
    public static void main(String[] args) {
        Q4 test = new Q4();
//        List<Integer> list = new LinkedList<>();
//        list.add(1);
//        list.add(3);
//        list.add(2);
//        list.add(3);
//        list.add(1);
//        list.add(3);
        int[] ints = {1,3,2,3,1,3};
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        test.longestEqualSubarray(list, 3);
    }
}
