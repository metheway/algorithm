import java.util.ArrayList;

public class fiftininth_maximum_in_queue {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
//        arr = new int[]{16,14,12,10,8,6,4};
        // 16, 14, 12
        System.out.println(maxInWindows(arr, 3));
//        System.out.println(maxInWindows(arr, 5));
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (num == null || num.length == 0 || size <= 0 || num.length < size) {
            return new ArrayList<>();
        }

        // according to the target offer, it should be done in a data structure like queue
        ArrayList<Integer> indexQueue = new ArrayList<>();
        ArrayList<Integer> maxQueue = new ArrayList<>();

        // first, get list to its size
        int index = 0;

        while (index < num.length) {
            int current = num[index];
            while (!indexQueue.isEmpty() && current > num[indexQueue.get(0)]) {
                indexQueue.remove(0);
            }
            while (!indexQueue.isEmpty() && current > num[indexQueue.get(indexQueue.size() - 1)]) {
                indexQueue.remove(indexQueue.size() - 1);
            }

            // this bug should be aware, the direction to push number
            if (indexQueue.isEmpty() || current > num[indexQueue.get(0)]) {
                indexQueue.add(0, index);
            } else {
                indexQueue.add(index);
            }

            // judge if within the window
            while (!indexQueue.isEmpty() && (index - indexQueue.get(0) + 1) > size) {
                indexQueue.remove(0);
            }

            if (index >= size - 1) {
                maxQueue.add(num[indexQueue.get(0)]);
            }
            index++;
        }
        return maxQueue;
    }
}
