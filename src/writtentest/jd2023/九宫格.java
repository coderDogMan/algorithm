package writtentest.jd2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 九宫格 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] s = new String[3];
        for (int i = 0; i < n; i++) {
            int state1 = 0;
            int state2 = 0;
            for (int j = 0; j < 3; j++) {
                s[j] = in.readLine();
                if (s[j].equals("o*o")) state1 = 1;
                else if (s[j].equals("*o*")) state2 = 1;
            }
            for (int j = 0; j < 3; j++) {
                String str = "";
                for (int k = 0; k < 3; k++) {
                    str = str + s[k].charAt(j);
                }
                if (str.equals("o*o")) state1 = 1;
                else if (str.equals("*o*")) state2 = 1;
            }
            if (state1 >= 1 && state2 == 0) {
                System.out.println("yukari");
            } else if (state2 >= 1 && state1 == 0) {
                System.out.println("kou");
            } else {
                System.out.println("draw");
            }
        }

    }
}
