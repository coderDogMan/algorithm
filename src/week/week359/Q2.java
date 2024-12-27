package week.week359;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q2 {
    public int minimumSum(int n, int k) {
        int ans = 0;
        for (int i = 1; i <= k / 2 && n > 0; i++) {
            n--;
            ans += i;
        }
        while (n-- > 0) {
            ans += k;
            k++;
        }
        return ans;
    }

}

class Test2 {
    public static void main(String[] args) {
        Q2 test = new Q2();
        test.minimumSum(2, 6);
//        test.minimumSum(3, 5);
//        test.minimumSum(5, 4);
    }
}