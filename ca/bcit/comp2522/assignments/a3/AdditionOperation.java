package ca.bcit.comp2522.assignments.a3;

/**
 * The addition operation.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class AdditionOperation extends AbstractOperation {
    /**The char addition code for addition operation.*/
    static final char ADDITION_CODE = '+';
    /**
     * The constructor that passes addition code to superclass.
     * */
    public AdditionOperation() {
        super(ADDITION_CODE);
    }
    /**
     * A constructor that perform addition for operandA and operandB.
     * @param operandA is one of a operand.
     * @param operandB is another operand.
     * @return an int for addition.
     * */
    public int perform(final int operandA, final int operandB) {
        return operandA + operandB;
    }
}
