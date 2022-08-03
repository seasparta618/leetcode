package sort;

import java.util.Arrays;

public class HeapSortMax {

    public static void main(String[] args) {
        int[] ar = new int[]{5, 3, 9, 27, 6, 7, 10, 13};
        System.out.println("heap inserting");
        heapSort(ar);

    }

    private static int[] heapSort(int[] ar) {
        for (int index = 0; index < ar.length; index++) {
            heapInsert(ar, index);
        }
        System.out.println("heap inserted");
        int heapSize = ar.length;
        System.out.println("heapifying");
        swap(ar, 0, --heapSize);
        while (heapSize > 0) {
            heapify(ar, 0, heapSize);
            swap(ar, 0, --heapSize);
        }
        return ar;
    }

    private static void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
            System.out.println(Arrays.toString(nums));
        }
    }

    private static void heapify(int[] nums, int index, int heapSize) {
        int left = (index << 1) + 1;
        while (left < heapSize) {
            // check whether there is a right child meanwhile get the largest
            int largest = left + 1 < heapSize && nums[left] < nums[left + 1] ? left + 1 : left;
            largest = nums[largest] > nums[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(nums, largest, index);
            index = largest;
            left = (index << 1) + 1;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int a, int b) {
        if (a != b) {
            nums[a] = nums[a] ^ nums[b];
            nums[b] = nums[a] ^ nums[b];
            nums[a] = nums[a] ^ nums[b];
        }
    }


}
