import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class fortininth_ugly_num {
    public static void main(String[] args) {
        System.out.println(getUglyNumber_Solution(7));
    }
    public static int getUglyNumber_Solution(int index) {
        if (index <= 0) {
            return 0;
        }
        if (index == 1) {
            return 1;
        }

        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i < index; i++) {
            int min = minArr(result.get(t2) * 2, result.get(t3) * 3, result.get(t5) * 5);
            if (min == result.get(t2) * 2) {
                t2++;
            }
            if (min == result.get(t3) * 3) {
                t3++;
            }
            if (min == result.get(t5) * 5){
                t5++;
            }
            result.add(min);
        }
        return result.get(result.size() - 1);
    }

    private static int minArr(Integer... arr) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }
}
