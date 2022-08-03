package ListPractice;

public class Q21MergeTwoSortedList {
    public static void main(String[] args) {
        ListNode list1 = new ListNode().initializeSingleDirectionList(new int[]{1, 2, 3, 4, 5, 6, 7, 9999});
        ListNode list2 = new ListNode().initializeSingleDirectionList(new int[]{2, 4, 5, 6, 9, 10, 18});
        ListNode newNode = new Q21MergeTwoSortedList().mergeTwoLists(list1, list2);
        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode();
        ListNode head = node;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }
        if (list1 == null) {
            node.next = list2;
        } else {
            node.next = list1;
        }
        return head.next;
    }
}
