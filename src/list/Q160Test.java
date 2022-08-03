package list;

import org.junit.Test;

public class Q160Test {
    @Test
    public void test() {
        int[] publicArray = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] arr1 = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] arr2 = new int[]{5, 6, 7, 8, 9};
        // 11 in length
        ListNode pubList = new ListNode().initializeSingleDirectionList(publicArray);
        // 9 in length
        ListNode l1 = new ListNode().initializeSingleDirectionList(arr1);
        // 5 in length
        ListNode l2 = new ListNode().initializeSingleDirectionList(arr2);
        assert new Q160IntersectionOfTwoLinkedLists().getIntersectionNode(l1, l2) == null;

        for (ListNode node = l1; node != null; node = node.next) {
            if (node.next == null) {
                node.next = pubList;
                break;
            }
        }
        for (ListNode node = l2; node != null; node = node.next) {
            if (node.next == null) {
                node.next = pubList;
                break;
            }
        }
        ListNode interSection = new Q160IntersectionOfTwoLinkedLists().getIntersectionNode(l1, l2);
        assert interSection.val == publicArray[0];
    }
}
