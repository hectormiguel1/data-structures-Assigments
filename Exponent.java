/**************************************************************
 Purpose/Description: This program is designed compute a number raised to another number in a sublinear time complexity.
 In order to achieve this we must cut the program in half in constant time. In order to this we can define that:
 X^N = X^(N/2) * X^(N/2). This allows us to greatly cut down the processing time and solve the problem in a recursive manner.
 splitting the exponent in 2 can be done in constant time and to save processing resources we can store the result of
 X^(N/2) into a temporary variable to prevent doing the same operation twice. This allows is to bring down the number of
 multiplications done from 63 to only 12 in the case of X^63. which is < (N/2)/2.
 Author’s Panther ID:
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/
public class Exponent {
    static final int DEFAULT_VALUE_ONE = 0;
    static final int NUMBER_TO_ZERO = 1;
    static int multiplicationCount = 0;


    public static void main(String[] args) {
        long base = 2;
        int exponent = 63;
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
            multiplicationCount++;
            return tmp * tmp;
        }
        multiplicationCount += 2;
        return (base * tmp * tmp);
    }
}

