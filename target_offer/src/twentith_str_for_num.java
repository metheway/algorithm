public class twentith_str_for_num {
    private static int index = 0;
    public static void main(String[] args) {
        System.out.println(isNumeric("+100.".toCharArray()));
        System.out.println(isNumeric("+5e2.".toCharArray()));
        System.out.println(isNumeric("+12e".toCharArray()));
        System.out.println(isNumeric("123.45e+6".toCharArray()));
        System.out.println(isNumeric("1a3.14".toCharArray()));
    }
    public static boolean isNumeric(char[] str) {
        index = 0;
        if (str == null || str.length == 0) {
            return false;
        }
        // judge from signed integer, ., E, num
        boolean isNum = false;
        isNum = scanInteger(str);
        // does have number before .

        if (index < str.length && '.' == str[index]) {
            // if exist ., continue to scan str
            index++;
            // should run scan but could be empty
            isNum = scanUnsignedInteger(str) || isNum;
        }

        if (!(index < str.length)) {
            return isNum;
        }
        if (str[index] == 'E' || str[index] == 'e') {
            // should scan num after e
            index++;
            isNum = scanInteger(str) && isNum;
        }
        return (index == str.length) && isNum;
    }

    private static boolean scanUnsignedInteger(char[] str) {
        boolean flag = false;
        if (index >= str.length) {
            return false;
        }
        while (index < str.length) {
            if (str[index] >= '0' && str[index] <= '9') {
                index++;
                flag = true;
            } else {
                break;
            }
        }
        return flag;
    }

    private static boolean scanInteger(char[] str) {
        if (index >= str.length) {
            return false;
        }
        if (str[index] == '+' || str[index] == '-'){
            index++;
            return scanUnsignedInteger(str);
        } else {
            return scanUnsignedInteger(str);
        }
    }
}
