package week.weektwo121;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class T3 {

    public int minimumOperationsToMakeEqual(int x, int y) {

        LinkedList<Integer> queue = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        queue.add(x);
        set.add(x);
        int ans = 0;
        while (!queue.isEmpty()) {
            if (set.contains(y)) return ans;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                x = queue.poll();
                if (x % 11 == 0 && !set.contains(x / 11)) {
                    queue.add(x / 11);
                    set.add(x / 11);
                }
                if (x % 5 == 0 && !set.contains(x / 5)) {
                    queue.add(x / 5);
                    set.add(x / 5);
                }
                if (!set.contains(x - 1)) {
                    queue.add(x - 1);
                    set.add(x - 1);
                }
                if (!set.contains(x + 1)) {
                    queue.add(x + 1);
                    set.add(x + 1);
                }
            }
            ans++;
        }
        return -1;
    }


}

class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        t3.minimumOperationsToMakeEqual(26, 1);
    }
}