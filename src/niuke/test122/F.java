package niuke.test122;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        LinkedList[] g = new LinkedList[n + 1];
        Arrays.setAll(g, e -> new LinkedList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
        }



    }
}
