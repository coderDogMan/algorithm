package writtentest.meituan2023;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int m1 = in.nextInt();
        int n2 = in.nextInt();
        int m2 = in.nextInt();
        double[] arr1 = new double[1000];
        double[] arr2 = new double[1000];
        double[] sum1 = new double[1000];
        double[] sum2 = new double[1000];
        arr1[0] = n1;
        arr2[0] = n2;
        sum1[0] = n1;
        sum2[0] = n2;
        for (int i = 1; i < 1000; i++) {
            arr1[i] = Math.sqrt(arr1[i - 1]);
            sum1[i] = sum1[i - 1] + arr1[i];
            arr2[i] = Math.sqrt(arr2[i - 1]);
            sum2[i] = sum2[i - 1] + arr2[i];
        }

        System.out.printf("%.2f", sum1[m1 - 1]);
        System.out.println();
        System.out.printf("%.2f", sum2[m2 - 1]);
    }
}
