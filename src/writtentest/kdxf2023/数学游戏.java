package writtentest.kdxf2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 数学游戏 {
    public static void main(String[] args) {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashSet<Integer> point = new HashSet<>();
        for (int i = 0; i < n; i++)
            point.add(in.nextInt());
        int s = in.nextInt();
        int ans = (s - 1);
//        5  1 4 2 3  3 2  4 1
//        6  1 5 2 4 3 3 4 2 5 1
//        int ans = 0;
        //  4 6 6 4
        for (Integer key : point) {
            if (key >= s) continue;
            if (key < s && !point.contains(s - key)) ans -= 2;
            else if (key < s && point.contains(s - key)) ans--;

        }
        System.out.println(ans);
    }
}
// 1 9 2 8 3 7 4 6 5 5