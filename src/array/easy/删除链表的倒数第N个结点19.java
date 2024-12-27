package array.easy;

public class 删除链表的倒数第N个结点19 {
    public static void main(String[] args) {
        removeNthFromEnd(new ListNode(1), 1);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode image = new ListNode();
        image.next = head;
        ListNode quick = image;
        ListNode low = image;
        while (n-- >= 0) {
            quick = quick.next;
        }
        while (quick != null) {
            quick = quick.next;
            low = low.next;
        }
        low.next = low.next.next;
        return image.next;
    }
}
