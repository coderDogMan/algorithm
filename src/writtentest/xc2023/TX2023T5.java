package writtentest.xc2023;

import java.util.ArrayList;

public class TX2023T5 {
    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        // write code here
        int mod = 1000000007;
        int n = a.size();
        int[] sum2 = new int[n + 1];
        int[] sum5 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int num = a.get(i);
            int s2 = 0, s5 = 0;
            while (num % 2 == 0) {
                s2++;
                num /= 2;
            }
            while (num % 5 == 0) {
                s5++;
                num /= 5;
            }
            sum2[i + 1] = sum2[i] + s2;
            sum5[i + 1] = sum5[i] + s5;
        }
        int i = 1, j = 1;
        while (sum2[j] < x || sum5[j] < x) {
            j++;
        }
        int ans = 0;
        while (j <= n) {
            while (sum2[j] - sum2[i] >= x && sum5[j] - sum5[i] >= x)
                i++;
            ans = (ans + i) % mod;
            j++;
        }
        return ans;
    }
}

class Test4 {
    public static void main(String[] args) {
        TX2023T5 test = new TX2023T5();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(3);
        list.add(50);
        list.add(4);
//        ArrayList<Integer> list = new ArrayList(Arrays.asList());
        test.getSubarrayNum(list, 2);
    }
}