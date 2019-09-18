public class Exponent {
    static final int DEFAULT_VALUE_ONE = 0;
    static final int NUMBER_TO_ZERO = 1;
    static int multiplicationCount = 0;


    public static void main(String[] args) {
        long base = 2;
        int exponent = 62;
        System.out.println(base + " raised to the " + exponent + " = " + exponent(base, exponent)
                + " multiplication count: " + multiplicationCount);
    }

    /**
     * This algorithm uses the divide and conquer approach to bring down the computational complexity down to log n.
     * it is established that that x^n = x^(n/2) * x^(n/2), by storing the result of one of the x^(n/2) into a temporary
     * variable we can effectively split the computational complexity by half, this is because splitting the exponent in
     * 2 can be done in O(c) or O(1) complexity. To take into account the exponent being an odd number, we can check if
     * the n % 2 equals 0 and if it is multiplying the tmp variable by it self, otherwise we can add the third multiplication,
     * of x * tmp * tmp.
     * Multiplication count used to solve question C.
     * @param base:     long base to be raised to the exponent.
     * @param exponent: int long value of the exponent.
     * @return: long value representing x^n. or base^exponent.
     */
    public static long exponent(long base, int exponent) {

        if (exponent == DEFAULT_VALUE_ONE) {
            return NUMBER_TO_ZERO;
        }
        long tmp = exponent(base, exponent / 2);

        if (exponent % 2 == 0) {
            multiplicationCount += 2;
            return tmp * tmp;
        }
        multiplicationCount += 3;
        return (base * tmp * tmp);
    }
}

