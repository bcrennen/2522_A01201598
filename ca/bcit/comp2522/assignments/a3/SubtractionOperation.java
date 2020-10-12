package ca.bcit.comp2522.assignments.a3;

/**
 * The subtraction operation.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class SubtractionOperation extends AbstractOperation {
    /**The char subtraction code for subtraction operation.*/
    static final char SUBTRACTION_CODE = '-';
    /**
     * The constructor that passes subtraction code to superclass.
     * */
    public SubtractionOperation() {
        super(SUBTRACTION_CODE);
    }
    /**
     * A constructor that perform subtraction for operandA and operandB.
     * @param operandA is one of a operand.
     * @param operandB is another operand.
     * @return an int for subtraction.
     * */
    public int perform(final int operandA, final int operandB) {
        return operandA - operandB;
    }
}
