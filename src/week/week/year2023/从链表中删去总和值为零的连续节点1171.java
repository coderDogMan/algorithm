package week.week.year2023;


import java.util.LinkedList;

public class 从链表中删去总和值为零的连续节点1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == 0) {
                cur = cur.next;
                continue;
            }
            if (stack.isEmpty()) {
                stack.add(cur);
            } else {
                int sum = 0;
                int num = 0;
                boolean flag = false;
                for (int i = stack.size() - 1; i >= 0; i--) {
                    sum += stack.get(i).val;
                    num++;
                    if (sum + cur.val == 0) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    while (num-- > 0) {
                        stack.pollLast();
                    }
                } else {
                    stack.add(cur);
                }
            }
            cur = cur.next;
        }
        ListNode dummy = new ListNode();
        cur = dummy;
        while (!stack.isEmpty()) {
            ListNode node = stack.pollFirst();
            node.next = null;
            cur.next = node;
            cur = cur.next;
        }
        return dummy.next;
    }
}

class Test10 {
    public static void main(String[] args) {
        从链表中删去总和值为零的连续节点1171 test = new 从链表中删去总和值为零的连续节点1171();
        test.removeZeroSumSublists(new ListNode(5, new ListNode(-3, new ListNode(-4, new ListNode(1, new ListNode(6, new ListNode(2, new ListNode(5))))))));
        test.removeZeroSumSublists(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(-2))))));
//        test.removeZeroSumSublists(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(4))))));
    }
}
