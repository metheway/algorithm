import java.util.Random;

public class eleventh_roatation_array_minimum {
    public static void main(String[] args) {
        int[] rotateArray = new int[]{3, 4, 5, 1, 2};
        quickSort(rotateArray, 0, rotateArray.length - 1);
        System.out.println(rotateArray);
        for (int i:rotateArray
             ) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();

        // how to locate the target as soon as possible
        int minimum = getMinimumInRot(rotateArray);
        System.out.println("minimum is:" + minimum);

    }

    private static int getMinimumInRot(int[] rotateArray) {
        // if the rotate array is an incremental array which means the rotate num is 0
        if (rotateArray[0] < rotateArray[rotateArray.length - 1]) {
            return rotateArray[0];
        }
        int left = 0;
        int right = rotateArray.length - 1;
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (rotateArray[mid] > rotateArray[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return rotateArray[left];
    }

    private static void quickSort(int[] rotateArray, int left, int right) {
        if (right <= left) {
            return;
        }
        int pivot = partition(rotateArray, left, right);
        quickSort(rotateArray, left, pivot - 1);
        quickSort(rotateArray, pivot + 1, right);
    }

    private static int partition(int[] rotateArray, int left, int right) {
        int index = new Random().nextInt(right - left) + left;
        int target = rotateArray[index];
        // restore the target value and swap to the right side
        Arrayswap(rotateArray, index, left);
        index = left;
        while (left < right) {
            while (left < right && rotateArray[left] < target) {
                left++;
            }
            rotateArray[index] = rotateArray[left];
            index = left;
            while (left < right && rotateArray[right] > target) {
                right--;
            }
            rotateArray[index] = rotateArray[right];
            index = right;
        }
        rotateArray[left] = target;
        return left;
    }

    private static void Arrayswap(int[] rotateArray, int index, int right) {
        int tmp = rotateArray[index];
        rotateArray[index] = rotateArray[right];
        rotateArray[right] = tmp;
    }
}
