public class thirtinineth_more_than_half {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 2, 5, 5, 2, 4, 2, 2, 2};
//        array = new int[]{1, 2, 3, 2, 2, 5, 4, 2, 2};
//        array = new int[]{1,2,3,2,4,2,5,2,3};
//        array = new int[]{4,2,1,4,2,4};
        array = new int[]{4,2,4,1,4,2};
        int num;
        // partition and judge
        num = moreThanHalfNum_Solution(array);

//        num = SecMore(array);
        System.out.println(num);
    }

    private static int SecMore(int[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int count = 1;
        int num = array[0];
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count = 1;
            } else if (array[i] == num) {
                count++;
            } else {
                count--;
            }
        }

        if (count <= 1) {
            return 0;
        }
//        if (array[array.length - 1] == num && count == 1) {
//            return 0;
//        }
        return num;
    }

    public static int moreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        // get num in its range
        int index = 0;
        int start = 0;
        int end = array.length - 1;
        index = partition(array, start, end);
        while (index != array.length / 2) {
            if (index < array.length / 2) {
                // should be in right side
                start = index + 1;
            }
            if (index > array.length / 2) {
                end = index - 1;
            }
            index = partition(array, start, end);
            System.out.println("index:" + index);
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[index]) {
                count++;
            }
        }
        if (count <= array.length / 2) {
            return 0;
        }
        return array[index];
    }

    private static int partition(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        int target = array[mid];

        // swap index to low postion
        swap(array, mid, start);
        while (start < end) {
            while (start < end && array[end] >= target) {
                end--;
            }
            array[start] = array[end];
            while (start < end && array[start] <= target) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = target;
        return start;
    }

    private static void swap(int[] array, int index, int low) {
        int tmp = array[index];
        array[index] = array[low];
        array[low] = tmp;
    }
}
