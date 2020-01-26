public class third_repeat_num {
    private static int repeatNum = -1;
    public static void main(String[] args){
        int[] input = new int[] {
            2, 1, 0, 7, 6, 4, 5, 3, 5
        };

        // find any repeat num in an array
        System.out.println(existsRepeatNum(input, 0 ,input.length) + " : " +
                repeatNum);

        repeatNum = -1;
        // find any repeat num without changing order of the array
        // we would rather take the array the same as former pro
        System.out.println(existsRepeatNumWithFixOrder(input, 0, input.length) + " : " + repeatNum);
    }

    private static boolean existsRepeatNumWithFixOrder(int[] input, int start, int end) {
        if (!isLegal(input, start, end)) {
            return false;
        }

        // take advantage of recursive
        int mid;
        int count = 0;
        end--;
        while(start <= end) {
            mid = start + ((end - start) >> 1);
            count = getCountSmallerThanMid(input, mid);
            if (start == end) {
                if (count > 1) {
                    repeatNum = input[start];
                    return true;
                } else {
                    break;
                }
            }
            if (count > (mid - start + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    private static int getCountSmallerThanMid(int[] input, int mid) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] <= mid  && input[i] >= 0) {
                count++;
            }
        }
        return count;
    }


    private static boolean existsRepeatNum(int[] input, int start, int end) {
        if (!isLegal(input, start, end)) return false;
        for (int i = start; i < end; i++) {
            while (i != input[i]) {
                if (input[input[i]] == input[i]) {
                    repeatNum = input[i];
                    return true;
                }else {
                    int tmp = input[i];
                    input[i] = input[tmp];
                    input[tmp] = tmp;
                }
            }
        }
        return false;
    }

    private static boolean isLegal(int[] input, int start, int end) {
        if (input == null || input.length <= 0) {
            return false;
        }
        if (start < 0) {
            return false;
        }
        for (int i = start; i < end; i++) {
            if (input[i] >= end || input[i] < start) {
                return false;
            }
        }
        return true;
    }
}
