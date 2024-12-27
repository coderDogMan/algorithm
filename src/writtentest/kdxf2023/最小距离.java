package writtentest.kdxf2023;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class 最小距离 {
    public static void main(String[] args) {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++)
            A[i] = in.nextInt();
        for (int i = 0; i < n; i++) {
            B[i] = in.nextInt();
            sum += Math.min(Math.abs(A[i] - B[i]), Math.abs(A[i] + B[i]));
        }
        System.out.println(sum);


    }
}
