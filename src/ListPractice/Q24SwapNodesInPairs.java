package ListPractice;

public class Q24SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode list1 = new ListNode().initializeSingleDirectionList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        list1 = new Q24SwapNodesInPairs().swapPairs(list1);
        while (list1 != null) {
            System.out.print(list1.val + "->");
            list1 = list1.next;
        }
        list1 = new ListNode().initializeSingleDirectionList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        list1 = new Q24SwapNodesInPairs().swapPairs(list1);
        System.out.println(list1);
        while (list1 != null) {
            System.out.print(list1.val + "->");
            list1 = list1.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(0, head);
        ListNode start = pre;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && fast != null) {
            ListNode next = fast.next;
            pre.next = fast;
            fast.next = slow;
            slow.next = next;
            pre = slow;
            slow = slow.next;
            if (slow != null) {
                fast = slow.next;
            }
        }
        return start.next;
    }
}
