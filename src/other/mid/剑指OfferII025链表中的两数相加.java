package other.mid;

public class 剑指OfferII025链表中的两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = null;
        while (l1 != null) {
            ListNode temp = l1.next;
            l1.next = pre;
            pre = l1;
            l1 = temp;
        }
        l1 = pre;
        pre = null;
        while (l2 != null) {
            ListNode temp = l2.next;
            l2.next = pre;
            pre = l2;
            l2 = temp;
        }
        l2 = pre;
        int bit = 0;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            ListNode node = new ListNode((l1.val + l2.val + bit) % 10);
            bit = (l1.val + l2.val + bit) / 10;
            p.next = node;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                ListNode node = new ListNode((l1.val + bit) % 10);
                bit = (l1.val + bit) / 10;
                p.next = node;
                p = p.next;
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
                ListNode node = new ListNode((l2.val + bit) % 10);
                bit = (l2.val + bit) / 10;
                p.next = node;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (bit != 0) {
            p.next = new ListNode(bit);
        }
        ListNode head = dummy.next;
        ListNode cur = head;
        pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

class Test18 {
    public static void main(String[] args) {
        剑指OfferII025链表中的两数相加 test = new 剑指OfferII025链表中的两数相加();
        test.addTwoNumbers(new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3)))),
                new ListNode(5, new ListNode(6, new ListNode(4))));
    }
}