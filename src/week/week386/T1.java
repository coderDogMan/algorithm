package week.week386;

import java.util.HashMap;

public class T1 {

    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            map.merge(key, 1, Integer:: sum);
            if (map.get(key) > 2) return false;
        }
        return true;
    }

}
