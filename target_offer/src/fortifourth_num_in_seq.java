public class fortifourth_num_in_seq {
    public static void main(String[] args) {
        System.out.println(digitAtIndex(13));
    }

    private static int digitAtIndex(int index) {
        if (index < 0) {
            return -1;
        }
        if (index <= 10) {
            return index - 1;
        }

        int digits = 1;
        int start = 10;
        index -= 10;
//        int count = 10;
        // 10 - 100 - 1000
        while (index > 0) {
            start = (int) Math.pow(10, digits);
            digits++;
            if (index > start * 10) {
                index -= start * 10;
            } else {
                break;
            }
        }

        if (index > 0) {
            start += (index / digits);
        }
        return digitAtIndex(start, index % digits);
    }

    private static int digitAtIndex(int start, int index) {
        int digits = getDigit(start);
        while (digits - index > 0) {
            start /= 10;
            digits--;
        }
        return start % 10;
    }

    private static int getDigit(int start) {
        int digits = 0;
        while (start > 0) {
            digits++;
            start /= 10;
        }
        return digits;
    }
}
