package sort;

import java.util.Arrays;

public class SelectSort {

    public static int[] selectSort(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                array[i] = array[i] ^ array[min];
                array[min] = array[i] ^ array[min];
                array[i] = array[i] ^ array[min];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{19, 7, 20, 301, 15, 202, 17, 6,-1,-192,20948,-99999};
        System.out.println(Arrays.toString(selectSort(array)));
    }
}
