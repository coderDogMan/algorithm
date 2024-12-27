package array.easy;

public class 两两交换链表中的节点24 {
    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode image = new ListNode();
        image.next = head;
        ListNode cur = image;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next.next;
            ListNode temp1 = cur.next;
            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp;
            cur = cur.next.next;
        }
        return image.next;
    }

}
