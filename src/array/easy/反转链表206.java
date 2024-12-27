package array.easy;

public class 反转链表206 {
    public static void main(String[] args) {
        reverseList(new ListNode(1, new ListNode(2)));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode perv = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = perv;
            perv = cur;
            cur = temp;
        }
        return perv;
    }
}
