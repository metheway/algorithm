import java.util.*;

public class fortith_minimum_kth {
    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7};
        ArrayList<Integer> res = new ArrayList<>();
                // first method _ partition
        res = getNumFromPartition(input, 3);
        System.out.println(res);
        System.out.println(Arrays.toString(input));

//        res = getLeastNumbers_Solution(input, 3);
//        System.out.println(res);

    }

    private static ArrayList<Integer> getNumFromPartition(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || input.length < k) {
            return new ArrayList<>();
        }
        int start = 0;
        int end = input.length - 1;

        int[] result = new int[k];
        int index = partition(input, start, end);
        int times = 0;

        while (k > times) {
//            System.out.println("index:" + index);
//            System.out.println("start:" + start);

            if (index >= k) {
                // on the left side of index
                end = index - 1;
            } else {
                start = index + 1;
                if (result[index] == 0) {
                    times++;
                    result[index] = input[index];
//                    if (index == k - 1) {
//                        // on the left
//                        end = index - 1;
//                    } else {
//                        // on the right
//                        start = index + 1;
//                    }
                    // if index is smaller than k
//                  // just choose the part larger than index
                    start = index + 1;
                }
                System.out.println(index);
            }
            index = partition(input, start, end);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            res.add(result[i]);
        }
        return res;
    }

    private static int partition(int[] input, int start, int end) {
        if (end < start) {
            return 0;
        }
//        int rand = new Random().nextInt(end - start + 1);
//        int target = input[rand + start];
        int rand = start;
        int target = input[rand];
        swap(input, start, rand);

        while (start < end) {
            while (start < end && input[end] >= target) {
                end--;
            }
            input[start] = input[end];
            while (start < end && input[start] <= target) {
                start++;
            }
            input[end] = input[start];
        }
        input[start] = target;
        return start;
    }

    private static void swap(int[] input, int start, int mid) {
        int tmp = input[start];
        input[start] = input[mid];
        input[mid] = tmp;
    }

    public static ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        if (input == null || input.length == 0 || k > input.length || k <= 0) {
            return new ArrayList<>();
        }
        // use maxheap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return 1;
                } else if (o1 > o2){
                    return -1;
                } else {
                    return 0;
                }
            }
        });

//        SortedSet<Integer> maxHeap = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if (o1 < o2) {
//                    return 1;
//                } else if (o1 > o2){
//                    return -1;
//                } else {
//                    return 0;
//                }
//            }
//        });

        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.add(input[i]);
            } else {
                int max = maxHeap.peek();
                if (max > input[i]) {
                    maxHeap.poll();
                    maxHeap.add(input[i]);
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>(maxHeap);
        return res;
    }
}
