package list;

public class Q234PalindromeLinkedList {
    public static void main(String[] args) {
        int[] nums = new int[]{};
        ListNode head = new ListNode().initializeSingleDirectionList(nums);
        boolean isPalindrome = new Q234PalindromeLinkedList().isPalindrome(head);
        System.out.println(isPalindrome);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode middle = findMiddle(head);
        ListNode reversedHead = reverseList(middle);
        while (head != null && reversedHead != null) {
            if (head.val != reversedHead.val) {
                return false;
            }
            head = head.next;
            reversedHead = reversedHead.next;
            if (head == reversedHead) {
                break;
            }
        }
        return true;
    }

    private static ListNode findMiddle(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next != null) {
            slow = slow.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode head = node.next;
        ListNode pre = node;
        ListNode tail = node;
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
