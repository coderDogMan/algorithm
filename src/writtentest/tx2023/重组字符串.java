package writtentest.tx2023;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class 重组字符串 {

    static int ans = 0;
    static LinkedList<Character> path = new LinkedList<Character>();
    static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            String s = in.next();
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            arr[i] = String.valueOf(chars);
        }
        backtrack(arr, 0);
        System.out.println(ans);
    }

    public static void backtrack(String[] arr, int deep) {
        if (path.size() == n) {
            ans++;
            return;
        }
        HashSet<Character> set = new HashSet<>();
        String s = arr[deep];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                continue;
            } else {
                set.add(c);
            }
            if (path.contains(c)) {
                continue;
            } else {
                path.add(c);
                backtrack(arr, deep + 1);
                path.removeLast();
            }
        }
    }
}
