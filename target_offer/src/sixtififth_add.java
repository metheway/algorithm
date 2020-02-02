public class sixtififth_add {
    public static void main(String[] args) {
        System.out.println(add(10,2));
    }
    public static int add(int num1,int num2) {

        // 不要进位的, 一个1
        int notCarryBits = (num1 ^ num2);

        // 要进位的
        int carryBits = num1 & num2;
        // 进位
        carryBits = carryBits << 1;
        return carryBits + notCarryBits;
    }
}
