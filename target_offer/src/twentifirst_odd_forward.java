import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class twentifirst_odd_forward {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        // 1,3,5,7,2,4,6]
        // reOrderArrayInBook(array);
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

    private static void reOrderArray(int[] array) {
//        // just traverse the array for twice
//        Stack<Integer> stack = new Stack<Integer>();
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 == 1) {
//                stack.push(array[i]);
//            }
//        }
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 == 0) {
//                stack.push(array[i]);
//            }
//        }
//
//        for (int i = array.length - 1; i >= 0; i--) {
//            array[i] = stack.pop();
//        }

        // well, newcoder do not provide stack and List
        // we should import these packages
         ArrayList<Integer> list = new ArrayList<>();
         for (int i = 0; i < array.length; i++) {
             if (array[i] % 2 == 1) {
                 list.add(array[i]);
             }
         }
         for (int i = 0; i < array.length; i++) {
             if (array[i] % 2 == 0) {
                 list.add(array[i]);
             }
         }
         for (int i = 0; i < array.length; i++) {
             array[i] = list.get(i);
         }
    }

    public static void reOrderArrayInBook(int [] array) {
        if (array == null || array.length == 0) {
            return;
        }
        if (array.length == 1) {
            return;
        } else if (array.length == 2) {
            if (array[0] % 2 == 0) {
                int tmp = array[0];
                array[0] = array[1];
                array[1] = tmp;
            }
        }

        int left = array.length - 2;
        int right = array.length - 1;
        while (left >= 0 && right >= 0 && left < right) {
            // left -- until meet even num
            while (left >= 0 && array[left] % 2 != 0) {
                left--;
            }
            // right -- until meet odd one
            while (right >= 0 && array[right] % 2 != 1) {
                right --;
            }
            if (right < 0 || left < 0) {
                break;
            }

            if (left < right) {
                if (array[left] % 2 == 0 && array[right] % 2 == 1) {
                    int tmp = array[left];
                    array[left] = array[right];
                    array[right] = tmp;
                }
            } else {
                break;
            }
        }
    }
}
