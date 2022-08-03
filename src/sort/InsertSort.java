package sort;

import java.util.Arrays;

public class InsertSort {

    public static int[] insertSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j - 1 >= 0 && array[j - 1] > array[j]; j--) {
                array[j - 1] = array[j - 1] ^ array[j];
                array[j] = array[j - 1] ^ array[j];
                array[j - 1] = array[j - 1] ^ array[j];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, 1, 12, 19, 8, 6, 3, 11};
        System.out.println(Arrays.toString(insertSort(array)));
    }
}
