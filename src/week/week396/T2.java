package week.week396;

import java.util.HashMap;

/**
 * @Author: min
 * @Date:
 */
public class T2 {

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            String key = word.substring(i, i + k);
            map.merge(key, 1, Integer::sum);
        }
        int max = 0;
        int sum = 0;
        for (Integer value : map.values()) {
            sum += value;
            max = Math.max(max, value);
        }
        return sum - max;
    }
}

class Test2 {
    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.minimumOperationsToMakeKPeriodic("leetcodeleet", 4);
    }
}
