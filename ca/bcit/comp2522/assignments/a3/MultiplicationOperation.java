package ca.bcit.comp2522.assignments.a3;

/**
 * The multiplication operation.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class MultiplicationOperation extends AbstractOperation {
    /**The char multiplication code for multiplication operation.*/
    static final char MULTIPLICATION_CODE = '*';
    /**
     * The constructor that passes multiplication code to superclass.
     * */
    public MultiplicationOperation() {
        super(MULTIPLICATION_CODE);
    }
    /**
     * A constructor that perform multiplication for operandA and operandB.
     * @param operandA is one of a operand.
     * @param operandB is another operand.
     * @return an int for multiplication.
     * */
    public int perform(final int operandA, final int operandB) {
        return operandA * operandB;
    }
}
