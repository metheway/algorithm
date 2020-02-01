public class fiftithird_num_in_ordered_arr {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,3,3,3,4,5};
        arr = new int[]{3};
        System.out.println(getNumberOfK(arr, 3));
    }


    public static int getNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0 || k < array[0] || k > array[array.length - 1]) {
            return 0;
        }

        int count = 0;
        if (array[0] == k) {
            count = 1;
        }

        int left = 0;
        int right = array.length - 1;
        int mid;

        while (left < right) {
            mid = (left + right) >> 1;
            if (array[mid] > k) {
                right = mid - 1;
            } else if (array[mid] < k) {
                left = mid + 1;
            } else {
                count = getCount(array, k, mid);
                break;
            }
        }
        return count;
    }

    private static int getCount(int[] array, int k, int index) {
        int count = 1;
        int left = 0;
        int right = array.length - 1;
        for (int i = index - 1; i >= left && array[i] == k; i--) {
            count++;
        }
        for (int i = index + 1; i <= right && array[i] == k; i++) {
            count++;
        }
        return count;
    }
}
