package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * question url: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * question solution:
 */
public class Q19Test {
    @Test
    public void exampleTest() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        int n = 5;
        Q19RemoveNthNodeFromEndOfList q19 = new Q19RemoveNthNodeFromEndOfList();
        list.remove(list.size() - 5);
        ListNode node = new ListNode().initializeSingleDirectionList(arr);
        node = q19.removeNthFromEnd(node, 5);
        int index = 0;
        while (node != null) {
            assert node.val == list.get(index);
            node = node.next;
            index++;
        }
    }

    /**
     * randomly generate a test case
     * as required, all cased has length between 1 and 30
     * as required, all nodes value are between 0 and 100
     */
    @Test
    public void randomTest() {
        Random random = new Random();
        int length = random.nextInt(1, 30);
        int[] arr = new int[length];
        List<Integer> list = new ArrayList<>();
        int index = 0;
        while (index < length) {
            int number = random.nextInt(0, 100);
            arr[index] = number;
            list.add(number);
            index++;
        }
        int n = random.nextInt(1, length);
        ListNode node = new ListNode().initializeSingleDirectionList(arr);
        node = new Q19RemoveNthNodeFromEndOfList().removeNthFromEnd(node, n);
        list.remove(list.size() - n);
        index = 0;
        while(node != null){
            assert node.val == list.get(index);
            node = node.next;
            index++;
        }
    }
}
