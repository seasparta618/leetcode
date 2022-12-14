package list;

public class Q160IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode l1, ListNode l2) {
        // special cases
        if (l1 == null || l2 == null) {
            return null;
        }
        if (l1.next == null && l2.next == null && l1 != l2) {
            return null;
        }
        ListNode f1 = l1;
        ListNode f2 = l2;
        ListNode s1 = l1;
        ListNode s2 = l2;
        int length1 = 1;
        int length2 = 1;
        while (f1.next != null && f1.next.next != null) {
            f1 = f1.next.next;
            s1 = s1.next;
            length1++;
        }
        while (f2.next != null && f2.next.next != null) {
            f2 = f2.next.next;
            s2 = s2.next;
            length2++;
        }
        length1 = f1.next != null ? length1 << 1 : (length1 << 1) - 1;
        length2 = f2.next != null ? length2 << 1 : (length2 << 1) - 1;
        f1 = f1.next == null ? f1 : f1.next;
        f2 = f2.next == null ? f2 : f2.next;
        if (f1 != f2) {
            return null;
        }
        if (length1 > length2) {
            l1 = shift(l1, length1 - length2);
        } else {
            l2 = shift(l2, length2 - length1);
        }
        while (l1 != null) {
            if (l1 == l2) {
                return l1;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return null;
    }

    public ListNode shift(ListNode l, int count) {
        int index = 0;
        while (index < count) {
            l = l.next;
            index++;
        }
        return l;
    }
}
