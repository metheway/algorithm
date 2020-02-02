public class sixtifirst_seq_in_poker {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,5,4};
        System.out.println(isContinuous(arr));
    }
    public static boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 2 || numbers[i] == 4) {
                numbers[i] = 0;
            }
        }
        int[] pokers = new int[52];
        // if repeated, false
        for (int i = 0; i < numbers.length; i++) {
            pokers[numbers[i]]++;
        }
        for (int i = 1; i < pokers.length; i++) {
            if (pokers[i] > 1) {
                return false;
            }
        }

        // judge if king could occupy the skip parts
        int distance = 0;
        int maxIndex = pokers.length - 1;
        int minIndex = 1;
        while (maxIndex > minIndex) {
            if (pokers[maxIndex] > 0) {
                if (pokers[minIndex] > 0) {
                    break;
                }
            } else {
                maxIndex--;
            }
            if (pokers[minIndex] > 0) {
                if (pokers[maxIndex] > 0) {
                    break;
                }
            } else {
                minIndex++;
            }
        }
        if (maxIndex - minIndex - 1 > 3) {
            return false;
        } else {
            return true;
        }
    }
}
