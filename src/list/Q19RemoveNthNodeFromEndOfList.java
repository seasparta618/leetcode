package list;

/**
 * question url: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * question solution:
 */
public class Q19RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        int middle = 1;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            middle++;
        }
        int length = middle * 2 - 1;
        if (fast.next != null) {
            length = middle * 2;
        }
        if (length == n) {
            // remove head
            return head.next;
        }
        ListNode node = head;
        int removedIndex = length - n + 1;
        int index = 1;
        if (removedIndex > middle) {
            node = slow;
            index = middle;
        }
        while (node != null) {
            if (index + 1 == removedIndex) {
                node.next = node.next.next;
                break;
            }
            index++;
            node = node.next;
        }
        return head;
    }

}
