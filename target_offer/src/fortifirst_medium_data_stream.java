import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class fortifirst_medium_data_stream {
    private static void swap(int[] array, int right, int index) {
        int tmp = array[right];
        array[right] = array[index];
        array[index] = tmp;
    }
    private static void swap(ArrayList<Integer> array, int right, int index) {
        int tmp = array.get(right);
        array.set(right, array.get(index));
        array.set(index, tmp);
    }
    static class MaxHeap {
        // insert
        ArrayList<Integer> list;

        public MaxHeap() {
            list = new ArrayList<>();
        }

        public MaxHeap(int[] array) {
            for (int i = array.length / 2; i>= 0; i--) {
                adjustDown(array, i);
            }
            for (int i = 0; i < array.length; i++) {
                list.add(array[i]);
            }
        }

        private void adjustDown(int[] array, int index) {
            while (2 * index < array.length) {
                int left = index * 2 + 1;
                int right = index * 2 + 2;
                int targetIndex = left;
                // exchange with the larger one
                if (right >= array.length) {
                    targetIndex = left;
                } else {
                    if (array[left] > array[right]) {
                        targetIndex = left;
                    } else {
                        targetIndex = right;
                    }
                }
                if (array[targetIndex] > array[index]) {
                    swap(array, targetIndex, index);
                }
                // make num larger on top
                index *= 2;
            }
        }

        public boolean insert(int num) {
            // insert
            list.add(num);
            adjustUp(list);
            return true;
        }

        private void adjustUp(ArrayList<Integer> list) {
            // insert the node to the bottom of tree, index is last stack.size() - 1
            int index = list.size() - 1;
            int current = list.get(list.size() - 1);

            while (index / 2 >= 0) {
                int targetIndex = index / 2;
                if (current > list.get(targetIndex)) {
                    swap(list, targetIndex, index);
                    index = index / 2;
                } else {
                    break;
                }
                if (targetIndex == 0) {
                    break;
                }
            }
        }
        public int getTop() {
            return list.get(0);
        }

        public int removeTop() {
            int top = list.get(0);
            swap(list, list.size() - 1, 0);
            list.remove(list.size() - 1);
            adjustDown(list, 0);
            return top;
        }

        // max heap, get max to top
        private void adjustDown (ArrayList<Integer>list, int index) {
            while (index * 2 < list.size()) {
                int left = index * 2;
                int right = index * 2;
                int targetIndex = left;
                if (right >= list.size()) {
                    targetIndex = left;
                } else {
                    targetIndex = right;
                }

                if (list.get(targetIndex) < list.get(index)) {
                    swap(list, targetIndex, index);
                } else {
                    break;
                }
            }
        }

        public int size() {
            return list.size();
        }

        @Override
        public String toString() {
            return "MaxHeap{" +
                    "list=" + list +
                    '}';
        }
    }
//    static class MinHeap {
//        private ArrayList<Integer> list;
//
//        public int getSize() {
//            return list.size();
//        }
//
//        public MinHeap() {
//            list = new ArrayList<>();
//        }
//
//        // insert
//        public void insert(int num) {
//            list.add(num);
//            adjustup(list, num);
//        }
//
//        private void adjustup(ArrayList<Integer> list, int num) {
//            int current = list.get(list.size() - 1);
//            int index = list.size() - 1;
//            while (index / 2 >= 0) {
//                int targetIndex = index / 2;
//                if (list.get(targetIndex) > current) {
//                    swap(list, index, targetIndex);
//                    index = index / 2;
//                } else {
//                    break;
//                }
//
//                if (targetIndex <= 0) {
//                    break;
//                }
//            }
//        }
//
//        public int getTop() {
//            return list.get(0);
//        }
//
//        @Override
//        public String toString() {
//            return "MinHeap{" +
//                    "list=" + list +
//                    '}';
//        }
//
//        public int removeTop() {
//            int target = list.get(0);
//            swap(list, 0, list.size() - 1);
//            list.remove(list.size() - 1);
//            adjustDown(list, 0);
//            return target;
//        }
//
//        private void adjustDown(ArrayList<Integer> list, int index) {
//            int target = list.get(index);
//            int left = index * 2;
//            int right = left + 1;
//            while (index * 2 < list.size()) {
//                left = index * 2;
//                right = left + 1;
//                int targetIndex = left;
//                if (right >= list.size()) {
//                    targetIndex = left;
//                } else {
//                    targetIndex = right;
//                }
//                // make top the minimum
//                if (list.get(targetIndex) < target) {
//                    swap(list, targetIndex, index);
//                } else {
//                    break;
//                }
//            }
//        }
//    }
//    static MaxHeap maxHeap = new MaxHeap();
//    static MinHeap minHeap = new MinHeap();
    public static void main(String[] args) {
        // create max heap and min heap
        // i try to create the class by my own code
//        maxHeap.insert(1);
//        maxHeap.insert(55);
//        maxHeap.insert(2);
//        System.out.println(maxHeap);
//        System.out.println(maxHeap.getTop());
        int[] array = new int[]{5,2,3,4,1,6,7,0,8};
        for (int i = 0; i < array.length; i++) {
            Insert(array[i]);
        }
        System.out.println(GetMedian());
    }
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    static int count = 0;
    public static void Insert(Integer num) {
        if (count % 2 == 0) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            // add to min
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;
    }

    public static Double GetMedian() {
        if (count % 2 == 0) {
            return Double.valueOf(0.5d * maxHeap.peek() + 0.5d * minHeap.peek());
        } else {
            if (maxHeap.size() > minHeap.size()) {
                return Double.valueOf(maxHeap.peek());
            } else {
                return Double.valueOf(minHeap.peek());
            }
        }
    }
}
