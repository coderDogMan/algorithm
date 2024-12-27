package week.week401;

import java.util.Arrays;

/**
 * @Author: min
 * @Date:
 */
public class T3 {

    int[] rewardValues;
    int[][] memo;
    int max;
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        this.rewardValues = rewardValues;
        for (int i : rewardValues) {
            max = Math.max(max, i);
        }
        memo = new int[max + 1][rewardValues.length];
        for (int i = 0; i <= max; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0,0);
    }

    private int f(int x, int i) {
        if (i >= rewardValues.length) return 0;
        if (x > max) return Integer.MIN_VALUE / 2;
        if (memo[x][i] != -1) return memo[x][i];
        int res = f(x, i + 1);;
        if (x < rewardValues[i])
            res = Math.max(res, f(x + rewardValues[i],i + 1) + rewardValues[i]);
        return memo[x][i] = res;
    }
}
class Test3 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        System.out.println(t3.maxTotalReward(new int[]{1, 1, 3, 3}));
        System.out.println(t3.maxTotalReward(new int[]{1,6,4,3,2}));

    }
}



 class Test extends Father{
    private String name="test";

    public static void main(String[] args){
        Test test = new Test();

        System.out.println(test.getName());

    }

}

class Father{
    private String name="father";

    public String getName() {
        return name;

    }

}

