package week.weektwo110;

public class Q2 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            ListNode node = new ListNode(gcd(cur.val, next.val));
            cur.next = node;
            node.next = next;
            cur = next;
        }
        return head;

    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
