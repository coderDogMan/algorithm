package week.week.year2023;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 适合打劫银行的日子2100 {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        LinkedList<Integer> ans = new LinkedList<>();
        int n = security.length;
        if (time == 0)  {
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
            return ans;
        }
        int[] L = new int[n];
        int[] R = new int[n];
        Arrays.fill(L, 1);
        Arrays.fill(R, 1);
        for (int i = 1; i < n; i++) {
            if (security[i] <= security[i - 1]) {
                L[i] = L[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (security[i] <= security[i + 1]) {
                R[i] = R[i + 1] + 1;
            }
        }
        for (int i = time; i < n - time; i++) {
            if (L[i] > time && R[i] > time) {
                ans.add(i);
            }
        }
        return ans;
    }
}

class Test6 {
    public static void main(String[] args) {
        适合打劫银行的日子2100 test = new 适合打劫银行的日子2100();
        test.goodDaysToRobBank(new int[]{1,2,3,4}, 1);
//        test.goodDaysToRobBank(new int[]{5,3,3,3,5,6,2}, 2);
    }
}