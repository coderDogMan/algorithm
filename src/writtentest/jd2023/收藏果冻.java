package writtentest.jd2023;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class 收藏果冻 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            if (set.contains(num)) ans++;
            else set.add(num);
        }
        System.out.println(ans);
    }
}
