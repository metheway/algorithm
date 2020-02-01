import java.lang.reflect.Field;

public class fiftisixth_count_in_arr {
    public static void main(String[] args) {
//        int[] arr = new int[]{1,1,2,2,3,3,4,4,5};
//        int result = getCount(arr);
//        System.out.println(result);
//        int[] arrSec = new int[]{1,1,2,2,3,3,5,6};
//        int resultSec = getCountSec(arrSec);

        int[] arrNewCode = new int[]{2,4,3,6,3,2,5,5};
        arrNewCode = new int[]{1,1,3,6};
        int[] num1 = new int[]{0};
        int[] num2 = new int[]{0};
        FindNumsAppearOnce(arrNewCode, num1, num2);
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        num1[0] = 0;
        num2[0] = 0;
        int difDigit = 0;
        for (int i = 0; i < array.length; i++) {
            difDigit ^= array[i];
        }
        int posOfOne = getOnePos(difDigit);
        for (int i = 0; i < array.length; i++) {
            if (isOneAt(array[i], posOfOne)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
//            System.out.println("num1: " + num1[0]);
//            System.out.println("num2: " + num2[0]);
        }
        return;
    }
    private static int getCountSec(int[] arr) {
        int difDigit = 0;
        for (int i = 0; i < arr.length; i++) {
            difDigit ^= arr[i];
        }
        int posOfOne = getOnePos(difDigit);
        int numFirst = 0;
        int numSec = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isOneAt(arr[i], posOfOne)) {
                numFirst ^= arr[i];
            } else {
                numSec ^= arr[i];
            }
        }
//        System.out.println(numFirst);
//        System.out.println(numSec);
        return difDigit;
    }

    private static boolean isOneAt(int num, int posOfOne) {
        // this is a bug, we shall rem the pos of 1
        while (posOfOne > 1) {
            num = num >> 1;
            posOfOne--;
        }
        if ((num & 1) > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static int getOnePos(int difDigit) {
        int digits = 0;
        for (int i = 0; i < 64; i++) {
            digits++;
            if ((difDigit & 1) == 1) {
                return digits;
            }
            difDigit = difDigit >> 1;
        }
        return digits;
    }

    public static int getCount(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count = count ^ arr[i];
        }
        return count;
    }
}
