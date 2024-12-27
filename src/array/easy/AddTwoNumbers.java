package array.easy;

import java.sql.PreparedStatement;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        l1.val = 3;
        l1.next = new ListNode(7);
//        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode();
        l2.val = 9;
        l2.next = new ListNode(2);

        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode resultIndex = result;
        int count = 0;

        while (l1 != null && l2 != null) {
            resultIndex.next = new ListNode((l1.val + l2.val + count) % 10);
            count = (l1.val + l2.val + count) / 10;

            resultIndex = resultIndex.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            resultIndex.next = new ListNode((l1.val + count) % 10);
            count = (l1.val + count) / 10;
            resultIndex = resultIndex.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            resultIndex.next = new ListNode((l2.val + count) % 10);
            count = (l2.val + count) / 10;
            resultIndex = resultIndex.next;
            l2 = l2.next;
        }

        if (l2 == null && l1 == null && count != 0) {
            resultIndex.next = new ListNode(count % 10);
        }

        return result.next;
    }


    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
