package niuke.Round35;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i);
        }
        LinkedList<Integer> ex = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) {
            int x = in.nextInt();
            if (set.contains(x)) {
                set.remove(nums[i]);
            } else {
                ex.add(i);
            }
        }
        System.out.println(ex.size());
        for (Integer num : set) {
            System.out.println(ex.poll() + " " + num);
        }


    }
}
