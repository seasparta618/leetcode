package list;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, int nextVal) {
        this.val = val;
        this.next = new ListNode(nextVal);
    }

    public ListNode(int val, ListNode head) {
        this.val = val;
        this.next = head;
    }

    public ListNode initializeSingleDirectionList(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return null;
        }
        if (nums.length == 1) {
            return new ListNode(nums[0]);
        }
        ListNode head = new ListNode(nums[0]);
        int index = 1;
        ListNode next = head;
        while (index < nums.length) {
            next.next = new ListNode(nums[index]);
            next = next.next;
            index++;
        }
        return head;
    }
}
