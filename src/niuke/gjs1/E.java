package niuke.gjs1;

import java.io.*;
import java.util.TreeSet;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int q = Integer.parseInt(s[1]);
        s = in.readLine().split(" ");
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) set.add(Integer.parseInt(s[i]));
        while (q-- > 0) {
            String[] op = in.readLine().split(" ");
            int p = Integer.parseInt(op[0]);
            int x = Integer.parseInt(op[1]);


        }
    }
}
