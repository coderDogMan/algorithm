package array.mid;

import java.util.*;

public class 链表组件817 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, null))));
        int i = numComponents(listNode, new int[]{0, 1, 3});


    }

    public static int numComponents(ListNode head, int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            int num = head.val;
            for (int i = 0; i < nums.length; i++) {
                if (num == nums[i]) {
                    list.add(1);
                    break;
                } else if ( i == nums.length - 1) {
                    list.add(0);
                }
            }
            head = head.next;
        }
        boolean flag = true;
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1 && flag) {
                count++;
                flag = false;
            }
            if (list.get(i) == 0 && !flag) {
                flag = true;
            }

        }

        return count;
    }
}


