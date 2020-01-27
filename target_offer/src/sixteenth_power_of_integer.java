public class sixteenth_power_of_integer {
    public static void main(String[] args) {

    }
    public double Power(double base, int exponent) {
        // consider for the negative exponent
        if (base == 0) {
            // either the exponent being negative or positive, the result would be 0 if base is 0
            return 0;
        }
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        }
        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }
        if (exponent % 2 == 0) {
            return Power(base, exponent >> 1) * Power(base, exponent >> 1) ;
        } else {
            return Power(base, (exponent - 1) >> 1) * Power(base, (exponent - 1) >> 1) * base;
        }
    }
}
