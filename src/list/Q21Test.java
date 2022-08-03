package list;

import org.junit.Test;

import java.util.*;

public class Q21Test {
    @Test
    public void sampleTest() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 9999};
        int[] arr2 = new int[]{1, 2, 4, 5, 6, 34, 56, 198, 1827};
        ListNode list1 = new ListNode().initializeSingleDirectionList(arr1);
        ListNode list2 = new ListNode().initializeSingleDirectionList(arr2);
        ListNode newNode = new Q21MergeTwoSortedList().mergeTwoLists(list1, list2);
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }
        for (int num : arr2) {
            list.add(num);
        }
        list.sort(Comparator.comparingInt(o -> o));
        int index = 0;
        while (newNode != null) {
            assert list.get(index) == newNode.val;
            newNode = newNode.next;
            index++;
        }
    }

    @Test
    public void randomTest() {
        Random r = new Random();
        int length1 = r.nextInt(0, 50);
        int length2 = r.nextInt(0, 50);
        int largestLength = Math.max(length1, length2);
        int index = 0;
        int[] arr1 = new int[length1];
        int[] arr2 = new int[length2];
        List<Integer> list = new ArrayList<>();
        while (index < largestLength) {
            if (index < length1) {
                arr1[index] = r.nextInt(-100, 100);
                list.add(arr1[index]);
            }
            if (index < length2) {
                arr2[index] = r.nextInt(-110, 100);
                list.add(arr2[index]);
            }
            index++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        ListNode l1 = new ListNode().initializeSingleDirectionList(arr1);
        ListNode l2 = new ListNode().initializeSingleDirectionList(arr2);
        ListNode newNode = new Q21MergeTwoSortedList().mergeTwoLists(l1, l2);
        list.sort(Comparator.comparingInt(o -> o));
        index = 0;
        while (newNode != null) {
            assert list.get(index) == newNode.val;
            newNode = newNode.next;
            index++;
        }
    }
}
