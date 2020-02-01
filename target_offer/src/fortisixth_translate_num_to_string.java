public class fortisixth_translate_num_to_string {
    // this algorithm not in newcoder, so test has not been done completely
    public static void main(String[] args) {
        int num = 12258;
        int result = translate(num);
        System.out.println(result);
    }

    private static int translate(int num) {
        if (num < 0) {
            return -1;
        }
        return translate(String.valueOf(num));
    }

    private static int translate(String str) {
        if (str.length() <= 2) {
            // > 0 && < 10,
            if (str.compareTo("10") < 0) {
                return 1;
            } else if (str.compareTo("26") < 0) {
                return 2;
            } else {
                return 1;
            }
        }
        if (str.substring(0, 2).compareTo("26") < 0) {
            return translate(str.substring(2, str.length())) + translate(str.substring(1, str.length()));
        } else {
            return translate(str.substring(1, str.length()));
        }
    }
}
