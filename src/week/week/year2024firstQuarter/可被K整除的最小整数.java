package week.week.year2024firstQuarter;

import java.util.ArrayList;
import java.util.HashSet;

public class 可被K整除的最小整数 {
    public int smallestRepunitDivByK(int k) {
        ArrayList<Long> list = new ArrayList(19);
        list.add(1L);
        for (int i = 1; i < 19; i++) {
            list.add(list.get(list.size() - 1) * 10 + 1);
        }
        for (int i = 1; i <= 19; i++) {
            if (list.get(i - 1) % k == 0) return i;
        }
        return -1;
    }
}

class Test29 {
    public static void main(String[] args) {
        可被K整除的最小整数 test = new 可被K整除的最小整数();
        test.smallestRepunitDivByK(5);
    }
}
