package array.mid;

public class 环形链表II142 {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        ListNode image = new ListNode();
        image.next = head;
        ListNode quick = image;
        ListNode slow = image;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                ListNode index1 = head;
                ListNode index2 = slow;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
