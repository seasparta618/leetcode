package ListPractice;

public class Q206ReverseLinkedList {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        ListNode head = new ListNode().initializeSingleDirectionList(nums);
        head = new Q206ReverseLinkedList().reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode head = node.next;
        ListNode tail = node;
        ListNode pre = node;

        while (head != null) {
            node = head;
            head = head.next;
            node.next = pre;
            pre = node;
        }
        tail.next = null;
        return node;
    }

}
