import java.util.Comparator;
import java.util.PriorityQueue;

public class fortififth_minimum_of_array {
    public static void main(String[] args) {
        int[] array = new int[]{1,42,424,525,33};
        String result = printMinNumber(array);
        System.out.println(result);
    }
    public static String printMinNumber(int [] numbers) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
                // from small to large
                StringBuilder firstSb = new StringBuilder(o1);
                firstSb = firstSb.append(o2);
                StringBuilder secSb = new StringBuilder(o2);
                secSb = secSb.append(o1);
                if (firstSb.toString().compareTo(secSb.toString()) > 0) {
                    // should concat in o2, o1;
                    // o1 in end who is larger
                    return 1;
                } else {
                    return -1;
                }
                // have it a try
                // if the head char are the same, then the sec should compare to the former
            }
        });
        for(int i = 0; i < numbers.length; i++) {
            priorityQueue.offer(String.valueOf(numbers[i]));
        }
        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll());
        }
        return sb.toString();
    }
}
