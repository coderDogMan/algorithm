package writtentest.huawei2023;

import java.util.HashMap;
import java.util.Scanner;

public class k优雅阈值 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = in.nextInt();
        int left = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) == k) {
                int c = 0;
                while (arr[left] != arr[i]) {
                    c++;
                    if (map.get(arr[left]) == 1) {
                        map.remove(arr[left]);
                    } else {
                        map.put(arr[left], map.get(arr[left]) - 1);
                    }
                    left++;
                }
                ans += (n - i) * (c + 1);
                if (map.get(arr[left]) == 1) {
                    map.remove(arr[left]);
                } else {
                    map.put(arr[left], map.get(arr[left]) - 1);
                }
                left++;
            }
        }
        System.out.println(ans);
    }

}
//1 2 3 1 1 2 3 1