package week.weektwo115;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T1 {

    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int prev = 0;
        for (String word : words) {
            if (word.equals("prev")) {
                if (list.size() - prev - 1 >= 0) {
                    ans.add(list.get(list.size() - prev - 1));
                } else {
                    ans.add(-1);
                }
                prev++;
            } else {
                prev = 0;
                list.add(Integer.parseInt(word));
            }
        }
        return ans;
    }
}

class Test1 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("prev");
        list.add("prev");
        list.add("prev");

        t1.lastVisitedIntegers(list);
    }
}
