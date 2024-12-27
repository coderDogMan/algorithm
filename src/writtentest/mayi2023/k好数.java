package writtentest.mayi2023;

import java.util.ArrayList;
import java.util.Scanner;

public class k好数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        while (q-- > 0) {
            long l = in.nextLong();
            long r = in.nextLong();
            int k = in.nextInt();
            ArrayList<Long> list = new ArrayList<>(10);
            int pow = 0;
            while (list.size() == 0 || list.get(list.size() - 1) <= r) {
                int size = list.size();
                long last = list.size() > 0 ? list.get(size - 1) : 1;
                for (int i = 0; i < size - 1; i++) {
                    list.add(last + list.get(i));
                }
                list.add((long) Math.pow(k, pow));
                pow++;
            }
            int left = find(list, l - 1);
            int right = find(list, r  + 1) - 1;
            System.out.println(right - left + 1);
        }

    }

    private static int find(ArrayList<Long> list, long val) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) > val) {
                right = mid - 1;
            }  else {
                left = mid + 1;
            }
        }
        return left;
    }


}
