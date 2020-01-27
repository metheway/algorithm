public class nineteenth_pattern_match {
    public static void main(String[] args) {
//        System.out.println(match("aaa".toCharArray(), "a.a".toCharArray()));
//        System.out.println(match("aaa".toCharArray(), "ab*ac*a".toCharArray()));
        System.out.println(match("a".toCharArray(), ".*".toCharArray()));

    }
    public static boolean match(char[] str, char[] pattern)
    {
        if (str == null && pattern == null) {
            return false;
        }
        if (str.length == 0 && pattern.length == 0) {
            return true;
        } else if (str.length != 0 && pattern.length == 0) {
            return false;
        }
        if (str.length == 0) {
            if (pattern.length == 2 && pattern[1] == '*') {
                return true;
            } else {
                return false;
            }
        }
            // this bug is for "" --- ".*" && "." && "d*".
            // a && .*
//        } else if (str.length == 0) {
//            if (pattern.length == 2 && pattern[1] == '*') {
//                return true;
//            }
//            return false;
//        }

        if (pattern.length > 1 && pattern[1] == '*') {
            // skip or match once or match more
            if (pattern[0] == str[0] || pattern[0] == '.') {
                return match(str, String.valueOf(pattern).substring(2, pattern.length).toCharArray()) ||
                        match(String.valueOf(str).substring(1, str.length).toCharArray(),
                                String.valueOf(pattern).substring(2, pattern.length).toCharArray()) ||
                        match(String.valueOf(str).substring(1, str.length).toCharArray(), pattern);
            } else {
                return match(str, String.valueOf(pattern).substring(2, pattern.length).toCharArray());
            }
        } else {
            if (pattern[0] == '.' || pattern[0] == str[0]) {
                return match(String.valueOf(str).substring(1, str.length).toCharArray(),
                        String.valueOf(pattern).substring(1, pattern.length).toCharArray());
            }
            return false;
        }
    }
}
