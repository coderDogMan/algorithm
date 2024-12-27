package week.week.year2023;

import java.util.*;

public class 高访问员工2933 {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        HashMap<String, LinkedList<Integer>> map = new HashMap<>();
        for (List<String> access_time : access_times) {
            String k = access_time.get(0);
            Integer v = Integer.parseInt(access_time.get(1).substring(0, 2)) * 60 + Integer.parseInt(access_time.get(1).substring(2, 4));
            if (map.containsKey(k)) {
                map.get(k).add(v);
            } else {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(v);
                map.put(k, list);
            }
        }
        List<String> ans = new LinkedList<>();
        for (String key : map.keySet()) {
            LinkedList<Integer> list = map.get(key);
            Collections.sort(list);
            if (list.size() < 3) continue;
            int l = 0;
            for (int i = 1; i < list.size(); i++) {
                while (list.get(i) - list.get(l) > 60) {
                    l++;
                }
                if (i - l >= 2) {
                    ans.add(key);
                    break;
                }
            }
        }
        return ans;
    }
}

class Test88 {
    public static void main(String[] args) {
        高访问员工2933 test = new 高访问员工2933();
        List<List<String>> linkedList = new LinkedList<>();
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("a");
        list1.add("0549");
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("a");
        list2.add("0532");
        LinkedList<String> list3 = new LinkedList<>();
        list3.add("a");
        list3.add("0621");
        linkedList.add(list1);
        linkedList.add(list2);
        linkedList.add(list3);
        test.findHighAccessEmployees(linkedList);
    }

}