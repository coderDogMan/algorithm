package other.mid;

import java.util.PriorityQueue;

public class 排序链表148 {
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>((node1, node2) -> (node1.val - node2.val));
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        head = queue.poll();
        ListNode cur = head;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            cur.next = null;
        }
        return head;
    }
}


