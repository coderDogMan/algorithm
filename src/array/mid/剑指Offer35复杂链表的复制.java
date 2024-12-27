package array.mid;

public class 剑指Offer35复杂链表的复制 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.next.random == null) {
                cur.next.random = null;
            } else {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node ans = head.next;
        cur = ans;
        Node p = head;
        while (cur.next != null) {
            cur.next = cur.next.next;
            p.next = p.next.next;
            cur = cur.next;
            p = p.next;
        }
        p.next = null;
        return ans;
    }
}
//
//class Test {
//    public static void main(String[] args) {
//        剑指Offer35复杂链表的复制 test = new 剑指Offer35复杂链表的复制();
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        node1.next = node2;
//        node1.random = node2;
//        node2.random = node2;
//
//        test.copyRandomList(node1);
//    }
//}
//
