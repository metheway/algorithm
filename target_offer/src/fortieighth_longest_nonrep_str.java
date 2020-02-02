public class fortieighth_longest_nonrep_str {
    public static void main(String[] args) {
        String str = "arabcacfr";
        int result = withoutDuplication(str);
        System.out.println(result);
//        System.out.println(isRepeatedAndFindIndex("arabcacfr", 5, 3));
    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0 || length <= 0) {
            return false;
        }
        // partiion？二分查找？，找到第一个重复的数字, 0 ~ n - 1内
        // 放回去呗
        for (int i = 0; i < numbers.length; i++) {
            int index = numbers[i];
            if (i != index) {
                if (numbers[index] == index) {
                    // 若重复存在，
                    duplication[0] = index;
                    return true;
                } else {
                    // 不重复则换
                    swap(numbers, i, index);
                }
            }
        }
        return false;
    }

    private void swap(int[] numbers, int i, int index) {
        int tmp = numbers[i];
        numbers[i] = numbers[index];
        numbers[index] = tmp;
    }

    public static int withoutDuplication(String str) {
        int maxCount = 0;
        for (int i = 0; i < str.length(); i++) {
            int count = endsIndex(str, i);
            if (maxCount < count) {
                maxCount = count;
            }
        }
        return maxCount;
    }

    private static int endsIndex(String str, int index) {
        if (index == 0) {
            return 1;
        }
        int before = endsIndex(str, index - 1);

        // current char is repeated? then recalc
        int repeatIndex = isRepeatedAndFindIndex(str, index, before);
        // if repeated, find the length. else, plus 1
        int currentCount = repeatIndex != -1 ? (index - repeatIndex) : before + 1;
        return currentCount;
        // this is a stupid bug, bug remember to make sure the f(n) is value when ends in n
//        if (before < currentCount) {
//            return currentCount;
//        } else {
//            return before;
//        }
    }

    private static int isRepeatedAndFindIndex(String str, int index, int before) {
        if (str == null || str.length() == 0 || index < 0 || index >= str.length()) {
            return -1;
        }
        // return repeat index
        int repeatIndex = index - 1;

        while (str.charAt(repeatIndex) != str.charAt(index) && before > 0) {
            before--;
            repeatIndex--;
            if (repeatIndex < 0) {
                return -1;
            }
        }

        if (str.charAt(repeatIndex) == str.charAt(index)) {
            return repeatIndex;
        } else {
            return -1;
        }
    }
}
