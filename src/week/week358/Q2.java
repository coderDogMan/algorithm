package week.week358;


import java.util.HashMap;

public class Q2 {
    public ListNode doubleIt(ListNode head) {

        ListNode cur = head;
        HashMap<ListNode, ListNode> last = new HashMap<>();
        while (cur.next != null) {
            last.put(cur.next, cur);
            cur.val *= 2;
            cur = cur.next;
        }
        cur.val *= 2;
        int num = 0;
        while (cur != head) {
            int val = cur.val;
            cur.val = (val + num) % 10;
            num = (val + num) / 10;
            ListNode lastNode = last.get(cur);
            lastNode.next = cur;
            cur = lastNode;
        }
        int val = cur.val;
        cur.val = (val + num) % 10;
        num = (val + num) / 10;
        if (num == 0) return cur;
        else {
            ListNode node = new ListNode(num);
            node.next = cur;
            return node;
        }
    }
}

class Test2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
//        q2.doubleIt(new ListNode(5, new ListNode(0, new ListNode(2))));
        q2.doubleIt(new ListNode(9, new ListNode(9, new ListNode(9))));
//        q2.doubleIt(new ListNode(1, new ListNode(8, new ListNode(9))));
    }

}