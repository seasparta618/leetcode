package ListPractice;

import java.util.HashMap;
import java.util.Map;

public class Q1863RemoveDuplicatesFromAnUnsortedLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode().initializeSingleDirectionList(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 5, 6, 1, 2, 3, 3, 4, 4, 7});
        node = new Q1863RemoveDuplicatesFromAnUnsortedLinkedList().deleteDuplicatesUnsorted(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = head;
        Map<Integer, Integer> map = new HashMap<>();
        while (node != null) {
            Integer value = map.get(node.val);
            map.put(node.val, value == null ? 1 : ++value);
            node = node.next;
        }
        ListNode preHead = new ListNode(Integer.MAX_VALUE, head);
        ListNode pre = preHead;
        while (head != null) {
            // map.get(node.val) will not be null, no need to check null here
            if (map.get(head.val) >= 2) {
                pre.next = head.next;
                head = head.next;
                continue;
            }
            pre = head;
            head = head.next;

        }
        return preHead.next;
    }
}
