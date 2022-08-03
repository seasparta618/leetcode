package sort;

public class QuickSortBest {
    public static void main(String[] args) {

    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            swap(array, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partition(array, left, right);
            quickSort(array, left, p[0] - 1);
            quickSort(array, p[1] + 1, right);
        }
    }

    public static int[] partition(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(arr, ++less, right++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --more, left);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void swap(int[] array, int a, int b) {
        if ((a ^ b) != 0) {
            array[a] = a ^ b;
            array[b] = a ^ b;
            array[a] = a ^ b;
        }
    }
}
