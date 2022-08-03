package sort;

import java.util.Arrays;

public class MergeSort {

    private int[] array;

    public static void main(String[] args) {
        int[] testArray = new int[]{9, 3, 5, 4, 1, 2, 3, 6, 8, 7, 99, 3647, 2217, 8512};
        int[] test1 = Arrays.copyOfRange(testArray, 3, 6);
        int[] test2 = Arrays.copyOfRange(testArray, 6, 10 + 1);
        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        mergeSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }

    public static void mergeSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        mergeSort(array, 0, array.length - 1);
    }

    public static void mergeSort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }

        int middle = left + ((right - left) >> 1);
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        mergeSort(array, left, middle, right);
    }

    public static void mergeSort(int[] array, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int[] arr1 = Arrays.copyOfRange(array, left, middle + 1);
        int[] arr2 = Arrays.copyOfRange(array, middle + 1, right + 1);
        int p1 = 0, p2 = 0;
        while (p1 + p2 < arr1.length + arr2.length) {
            if (p1 == arr1.length || (p1 < arr1.length && p2 < arr2.length && arr1[p1] > arr2[p2])) {
                temp[p1 + p2] = arr2[p2];
                p2++;
                continue;
            }
            if (p2 == arr2.length || (p1 < arr1.length && p2 < arr2.length && arr1[p1] <= arr2[p2])) {
                temp[p1 + p2] = arr1[p1];
                p1++;
            }
        }
        for (int num : temp) {
            array[left] = num;
            left++;
        }
    }

}
