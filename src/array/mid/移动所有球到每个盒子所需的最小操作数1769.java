package array.mid;

import java.util.HashMap;
import java.util.LinkedList;

public class 移动所有球到每个盒子所需的最小操作数1769 {
    public static void main(String[] args) {
        minOperations("110");
    }

    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] list = new int[boxes.length()];
        int index = 0;
        for (int i = 0; i < n; i++)
            if (boxes.charAt(i) == '1')
                list[index++] = i;
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < index; j++) {
                res[i] += Math.abs(i - list[j]);
            }
        }
        return res;
    }
}
