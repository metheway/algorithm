import java.util.Arrays;

public class merge_sort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,1,21,5,125,1,4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        if (end < mid || mid < start) {
            return;
        }

        // just cp two arr to the final arr
        int[] cpArr = new int[arr.length];
        for (int i = start; i <= end; i++) {
            cpArr[i] = arr[i];
        }
        int i, j, k;
        for (i = mid, j = end, k = end; i >= start && j > mid; ) {
            if (cpArr[i] > cpArr[j]) {
                arr[k--] = cpArr[i--];
            } else {
                arr[k--] = cpArr[j--];
            }
        }

        while (i >= start) {
            arr[k--] = cpArr[i--];
        }
        while (j > mid) {
            arr[k--] = cpArr[j--];
        }
    }
}
