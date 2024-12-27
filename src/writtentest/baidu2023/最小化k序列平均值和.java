package writtentest.baidu2023;

import java.util.Arrays;
import java.util.Scanner;

public class 最小化k序列平均值和 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        double sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] += in.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < k - 1; i++) {
            sum += arr[i];
        }
        double realSum = 0;
        for (int i = k - 1; i < n; i++) {
            realSum += arr[i];
        }
        realSum /= (n - k + 1);


        System.out.printf("%.5f", sum + realSum);
    }
}
