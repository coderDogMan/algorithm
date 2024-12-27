package array.easy;

public class 删除排序链表中的重复元素83 {
    public static void main(String[] args) {
        deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(2))));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else  {
                cur = cur.next;
            }
        }

        return head;
    }
}

