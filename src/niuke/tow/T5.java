package niuke.tow;

import java.util.Scanner;

public class T5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = in.nextInt();
            arr[i] = arr[i - 1] + num;
        }
        while (q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(arr[r] - arr[l - 1]);
        }


    }
}
