package week.week.year2023;

import java.util.LinkedList;

public class 负二进制数相加1073 {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if (arr2.length > arr1.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int num = 0;
        LinkedList<Integer> ans = new LinkedList<>();
        while (i >= 0 && j >= 0) {
            if (arr1[i] + arr2[j] + num == 1) {
                ans.addFirst(1);
                num = 0;
            } else if (arr1[i] + arr2[j] + num == 0) {
                ans.addFirst(0);
                num = 0;
            } else if ((arr1[i] + arr2[j] + num == -1)) {
                ans.addFirst(1);
                num = 1;
            } else if ((arr1[i] + arr2[j] + num == 2)) {
                ans.addFirst(0);
                num = -1;
            } else if ((arr1[i] + arr2[j] + num == 3)) {
                ans.addFirst(1);
                num = -1;
            }
            i--;
            j--;
        }

        while (i >= 0) {
            if (arr1[i] + num == 1) {
                ans.addFirst(1);
                num = 0;
            } else if (arr1[i] + num == 0) {
                ans.addFirst(0);
                num = 0;
            } else if ((arr1[i] +  num == -1)) {
                ans.addFirst(1);
                num = 1;
            } else if ((arr1[i] + num == 2)) {
                ans.addFirst(0);
                num = -1;
            }
            i--;
        }
        if (num == -1) {
            ans.addFirst(1);
            ans.addFirst(1);
        } else if (num == 1) {
            ans.addFirst(1);
        }
        while (ans.size() >= 2 && ans.getFirst() == 0) {
            ans.pollFirst();
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Test64 {
    public static void main(String[] args) {
        负二进制数相加1073 test = new 负二进制数相加1073();
        test.addNegabinary(new int[]{1,0,1}, new int[]{1,0,1});
//        test.addNegabinary(new int[]{1}, new int[]{1,1});
//        test.addNegabinary(new int[]{1,1,1,1,1}, new int[]{1,0,1});
    }
}