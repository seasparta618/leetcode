package list;

public class Q92ReverseLinkedList {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 5};
        ListNode node = new ListNode().initializeSingleDirectionList(nums);
        int left = 1, right = 2;
        ListNode head = new Q92ReverseLinkedList().reverseBetween(node, left, right);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode reverseBetween(ListNode node, int left, int right) {
        if (node == null || node.next == null) {
            return node;
        }
        if (left == right) {
            return node;
        }
        int index = 1;
        ListNode l0 = node;
        ListNode head = node;
        ListNode pre = node;
        ListNode leftTail = node;
        ListNode rightHead = node;
        ListNode tail = node;
        while (head != null) {
            // record the left part's tail, direct connect this tail's next to the reversed head
            if (index == left - 1) {
                leftTail = head;
            }
            while (index > left && index <= right && head != null) {
                node = head;
                head = head.next;
                node.next = pre;
                pre = node;
                index++;
            }
            // record the right part's head, do not need to go further anymore
            if (index == right + 1) {
                rightHead = head;
                break;
            }
            tail = head;
            pre = head;
            head = head.next;
            index++;
        }

        leftTail.next = node;
        tail.next = rightHead;
        // in case the first one becomes reversed part's tail
        // == could work, as ListNode object is using the memory reference
        return l0 == tail ? node : l0;
    }
}
