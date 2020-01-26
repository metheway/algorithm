import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class sixth_reverse_print {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 41, 5, 12, 4, 15, 16};
        List<Integer> list = new ArrayList<Integer>(Arrays.<Integer>asList(array));
        reversePrint(list, 0);
    }

    private static void reversePrint(List<Integer> list, int index) {
        if (list == null || index >= list.size()) {
            return;
        }
        reversePrint(list, index + 1);
        System.out.println(list.get(index));
    }

    /** my first method
     *     ArrayList<Integer> result = new ArrayList<>();
     *     public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
     *         if (listNode == null) {
     *             return new ArrayList<>();
     *         }
     *         printListFromTailToHead(listNode.next);
     *         result.add(listNode.val);
     *         return result;
     *     }
     */

    /**
     *
     */
}
