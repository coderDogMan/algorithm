package week.gsdc.test1;

import java.util.LinkedList;
import java.util.Scanner;

public class TE {

    static int[] list = new int[9592];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        init();
        int ans = 0;
        for (int i = 0; i < 9592; i++) {
            int l = i;
            int r = 9592 - 1;

            while (l <= r) {
                if (list[i] + list[l] + list[r] == n) {
                    ans++;
                    l++;
                    r--;
                } else if (list[i] + list[l] + list[r] < n) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        System.out.println(ans);
    }
    private static void init() {
        boolean[] used = new boolean[100001];
        int idx = 0;
        for (int i = 2; i < 100001; i++) {
            if (!used[i]) {
                list[idx++] = i;
                for (int j = i; i * j >= 0 && j * i < 100001; j++) {
                    used[i * j] = true;
                }
            }
        }
    }
}


//    static LinkedList<Integer> path = new LinkedList<>();
//    static LinkedList<LinkedList> ans = new LinkedList<LinkedList>();
//    static int n;

//    private static void backtrack(int startIndex, int sum) {
//        if (path.size() == 3) {
//            if (sum == n) ans.add(new LinkedList(path));
//            return;
//        }
//        for (int i = startIndex; i < 9592; i++) {
//            if (sum + list[i] > n) break;
//            sum += list[i];
//            path.add(list[i]);
//            backtrack( i, sum);
//            sum -= list[i];
//            path.removeLast();
//        }
//    }