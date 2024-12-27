package writtentest.jd2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 单词 {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] arr = new long[300001];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= 300000; i++) {
            arr[i] = (arr[i - 1] * i) % MOD;
        }
        HashMap<Integer, HashMap<String, Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = in.next();
            if (map.get(s.length()) == null) {
                HashMap<String, Integer> hashMap = new HashMap<>();
                hashMap.put(s, 1);
                map.put(s.length(),hashMap);
            } else {
                HashMap<String, Integer> hashMap = map.get(s.length());
                hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
            }
        }

        long ans = 1;
        for (Integer len : map.keySet()) {
            HashMap<String, Integer> hashMap = map.get(len);
            int sum = 0;
            ArrayList<Integer> list = new ArrayList<>();
            for (String str : hashMap.keySet()) {
                int count = hashMap.get(str);
                sum += count;
                if (count >= 2) {
                    list.add(count);
                }
            }
            long temp = 1;
            for (Integer count : list) {
                temp = temp * pow(arr[count], MOD - 2) % MOD;
            }
            temp = temp * arr[sum] % MOD;
            ans = ans * temp % MOD;
        }
        System.out.println(ans);
    }

    private static long pow(long a, long b) {
        long ans = 1 , base = a;
        while (b > 0){
            if ((b & 1) == 1) ans = ans * base % MOD;
            b >>= 1;
            base = base * base % MOD;
        }
        return ans;
    }
}
