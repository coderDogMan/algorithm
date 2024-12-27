package writtentest.笔试360;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            String ans = "Yes";
            String s1 = in.next();
            String s2 = in.next();
            int[] zi1 = new int[10];
            int[] mu1 = new int[10];
            int[] zi2 = new int[10];
            int[] mu2 = new int[10];
            String[] split1 = s1.split("/");
            for (char c : split1[0].toCharArray()) zi1[c - '0']++;
            for (char c : split1[1].toCharArray()) mu1[c - '0']++;
            String[] split2 = s2.split("/");
            for (char c : split2[0].toCharArray()) zi2[c - '0']++;
            for (char c : split2[1].toCharArray()) mu2[c - '0']++;
//            if (check(split1[0], split2[0]) && check(split1[1], split2[1])) {
//                System.out.println("No");
//                return;
//            }
            int[] diff = new int[10];
            for (int i = 0; i < 10; i++) {
                diff[i] = zi1[i] - zi2[i];
                if (diff[i] < 0) ans = "No";
            }
            for (int i = 0; i < 10; i++) mu2[i] += diff[i];
            for (int i = 0; i < 10; i++) {
                if (mu1[i] != mu2[i]) ans = "No";
            }
            System.out.println(ans);
        }


    }

    private static boolean check(String s1, String s2) {
        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
        }
        return j == s2.length();
    }
}
