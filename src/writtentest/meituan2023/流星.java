package writtentest.meituan2023;

import java.util.Arrays;
import java.util.Scanner;

public class 流星 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // x y
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            arr[i][0] = in.nextInt();
        }
        for (int i = 0; i < n; i++){
            arr[i][1] = in.nextInt();
        }
        int max = 1;
        int temp = 1;
        int ans = 0;
        int left = 0;
        int right = n - 1;
        Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
        for (int i = 1; i < n; i++) {

        }

        System.out.println(max + " " + ans);
    }
}
