package niuke.week.Round34;

import java.util.LinkedList;
import java.util.Scanner;

public class T4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int[] nums = new int[n];
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++ ) {
            int x = in.nextInt();
            nums[i] = x;
            if (x != 0 && (list.isEmpty() || !list.isEmpty() && x != list.getLast())) {
                list.add(x);
            }
        }
        if (list.size() > 2) {
            System.out.println(-1);
        } else if (list.size() == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(list.getFirst() + " ");
            }
        } else {
            for (int x : nums) {
                if (list.size() == 2 && x == list.getLast()) {
                    list.pollFirst();
                }
                System.out.print(list.getFirst() + " ");
            }
        }

    }

}
