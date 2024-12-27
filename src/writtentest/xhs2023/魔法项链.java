package writtentest.xhs2023;

import java.io.*;

public class 魔法项链 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] s = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int u = Integer.parseInt(s[1]);
            s = in.readLine().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            long f0 = 0, f1 = 0, ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                f1 = Math.max(f1 + nums[i] ,f0 + u) ;
                f0 = Math.max(f0 ,0) + nums[i];

                ans = Math.max(ans, Math.max(f1, f0));
            }
            out.println(ans);
        }
        out.flush();
        in.close();
    }
}
