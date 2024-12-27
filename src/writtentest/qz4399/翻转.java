package writtentest.qz4399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 翻转 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] words = in.readLine().split(" ");
        int n = words.length;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            String s = words[i];
            int j = s.length() - 1;
            for (; j >= 0; j--) {
                char x = s.charAt(j);
                if (x >= 'a' && x <= 'z') {
                    x = (char) (x - 'a' + 'A');
                } else {
                    x = (char) (x - 'A' + 'a');
                }
                sb.append(x);
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
