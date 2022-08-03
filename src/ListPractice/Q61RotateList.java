package ListPractice;

public class Q61RotateList {
    public static void main(String[] args) {
        ListNode list = new ListNode().initializeSingleDirectionList(new int[]{0, 1, 2});
        list = new Q61RotateList().rotateRight(list, 4);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public ListNode rotateRight(ListNode node, int k) {
        if (node == null || node.next == null || k == 0) {
            return node;
        }
        ListNode fast = node;
        ListNode slow = node;
        int mid = 1;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            mid++;
        }
        ListNode tail = fast.next != null ? fast.next : fast;
        int length = (mid << 1) - 1;
        if (fast.next != null) {
            length = mid << 1;
        }
        int n = k % length;
        if (n == 0) {
            return node;
        }
        ListNode head = node;
        int startIndex = length - n + 1;
        int index = 1;
        if (startIndex > mid) {
            head = slow;
            index = mid;
        }
        ListNode newHead = node;
        while (index < startIndex) {
            if (index + 1 == startIndex) {
                newHead = head.next;
                head.next = null;
                break;
            }
            index++;
            head = head.next;
        }
        tail.next = node;
        return newHead;
    }
}
