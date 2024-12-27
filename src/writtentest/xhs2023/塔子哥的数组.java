package writtentest.xhs2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 塔子哥的数组 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        long n = Integer.parseInt(s[0]);
        long k = Integer.parseInt(s[1]);
        System.out.println((k + k * n) * n / 2);
    }
}
