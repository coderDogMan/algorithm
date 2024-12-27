package writtentest.huawei2023.od411;

import java.util.Arrays;
import java.util.Scanner;

public class 总最快检测效率 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] power = new int[n];
        Integer[] arr = new Integer[n * 4];
        int idx = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            power[i] = num / 5 * 4;
            ans += power[i];
            arr[idx] = num / 5;
            arr[idx + 1] = num / 10;
            arr[idx + 2] = num / 10;
            arr[idx + 3] = num / 10;
            idx += 4;
        }
        Arrays.sort(arr, (a, b) -> (b - a));
        idx = 0;
        while (k-- > 0 && idx < arr.length) {
            ans += arr[idx++];
        }
        System.out.println(ans);
    }
}
