public class fiftifirst_rev_seq {
    public static void main(String[] args) {
        int[] array = new int[]{7, 5, 6, 4};
        array = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(inversePairs(array));
    }
    // 超时了，用dp改写mergesort？
    static public int inversePairs(int [] array) {
        // split array
        splitArr(array, 0, array.length - 1);
        // merge two parts
        return count;
    }

    static int count = 0;
    private static void splitArr(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        splitArr(array, left, mid);
        splitArr(array, mid + 1, right);
        merge(array, left, mid, right);
        count %= 1000000007;
    }

    private static void merge(int[] array, int left, int mid, int right) {
        // left part and right part;
        int toBeAdd = right - (mid + 1) + 1;
        // we d like the result be sorted in ascending order
        // create an array
        int[] cp_arr = new int[array.length];
        for (int i = left; i <= right; i++) {
            cp_arr[i] = array[i];
        }

        int i, j, k;
        for (i = mid, j = right, k = right; i >= left && j > mid; ) {
            if (cp_arr[i] > cp_arr [j]) {
                // if the left part is larger,
                array[k--] = cp_arr[i--];
                count += toBeAdd;
            } else {
                array[k--] = cp_arr[j--];
                toBeAdd--;
            }
        }

        // left part has left
        while (i >= left) {
            // this bug should specific noticed
            count += toBeAdd;
            array[k--] = cp_arr[i--];
        }
        // if right part has left
        while (j >= mid + 1) {
            array[k--] = cp_arr[j--];
        }
    }

}
