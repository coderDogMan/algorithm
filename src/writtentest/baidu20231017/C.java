package writtentest.baidu20231017;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class C {
    static String ans = "";
    static int n;
    static String a;
    static String b;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        a = in.readLine();
        b = in.readLine();
        dfs(0, "");
        System.out.println(ans);
    }

    private static void dfs(int i, String s) {
        if (ans.length() > 0) return;
        if (i == n) {
            if (s.length() == n) {
                ans = s;
            }
            return;
        }
        if (!s.contains(a.charAt(i) + ""))
            dfs(i + 1, s + a.charAt(i));
        if (!s.contains(b.charAt(i) + ""))
            dfs(i + 1, s + b.charAt(i));
        if (s.contains(a.charAt(i) + "") && s.contains(b.charAt(i) + "")) return;

    }
}
