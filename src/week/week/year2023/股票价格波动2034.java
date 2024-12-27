package week.week.year2023;

import java.util.HashMap;
import java.util.TreeMap;

public class 股票价格波动2034 {

    HashMap<Integer, Integer> map;
    TreeMap<Integer, Integer> treeMap;
    int last;

    public 股票价格波动2034() {
        last = -1;
        map = new HashMap<>();
        treeMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)) {
            treeMap.remove(timestamp);
            treeMap.put(timestamp, price);

        } else {
            last = Math.max(last, timestamp);
            map.put(timestamp, price);
            treeMap.put(timestamp, price);
        }

    }

    public int current() {
        return map.get(last);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }
}
