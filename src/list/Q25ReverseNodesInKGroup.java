package list;

public class Q25ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode list1 = new ListNode().initializeSingleDirectionList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,13,14});
        list1 = new Q25ReverseNodesInKGroup().reverseKGroup(list1, 3);
        while (list1 != null) {
            System.out.println(list1.val);
            list1 = list1.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }
        int index = 1;
        ListNode pre = new ListNode(-1, head);
        ListNode start = pre;
        ListNode nextHead;
        while (head != null && head.next != null) {
            head = head.next;
            index++;
            if (index == k) {
                nextHead = head.next;
                head.next = null;
                ListNode[] nodes = reverseListNode(pre.next);
                pre.next = nodes[0];
                nodes[1].next = nextHead;
                index = 1;
                head = nextHead;
                pre = nodes[1];
            }
        }
        return start.next;
    }

    public ListNode[] reverseListNode(ListNode node) {
        ListNode head = node.next;
        ListNode pre = node;
        ListNode tail = node;
        while (head != null) {
            node = head;
            head = head.next;
            node.next = pre;
            pre = node;
        }
        return new ListNode[]{node, tail};
    }
}
