import java.util.ArrayList;

public class fiftiseventh_sum_of_s {
    public static void main(String[] args) {
        int[] arr = new int[]{1,233,4,41,51,6,2};
        arr = new int[]{1,2,4,7,11,15};
//        ArrayList<Integer> list = findNumbersWithSum(arr, 15);
//        System.out.println(list);
        ArrayList<ArrayList<Integer>> list = findContinuousSequence(15);
        for (ArrayList<Integer> seq : list
             ) {
            System.out.println(seq);
        }
    }
    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        if (array == null || array.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> list = new ArrayList<>();
        int left = 0;
        int right = array.length - 1;
        int indexFirst = -1;
        int indexSec = -1;

        while (left < right) {
            int twoSum = array[left] + array[right];
            if (twoSum == sum) {
                indexFirst = left;
                indexSec = right;
                break;
            } else if (twoSum < sum) {
                left++;
            } else {
                right--;
            }
        }
        if (indexFirst == -1 || indexSec == -1) {
            return list;
        }
        list.add(array[indexFirst]);
        list.add(array[indexSec]);
        return list;
    }
    public static ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> seq;
        if (sum == 0) {
            seq = new ArrayList<>();
            seq.add(1);
            list.add(seq);
            return list;
        }
        int left = 1;
        int right = 2;
        int total = left + right;
        while (left < right) {
            total = (left + right) * (right - left + 1) / 2;
            if (total == sum) {
                seq = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    seq.add(i);
                }
                list.add(new ArrayList<>(seq));
                left++;
            } else if (total < sum) {
                // now is small, should be larger
                right++;
            } else {
                left++;
            }
        }
        return list;
    }
}
