package ca.bcit.comp2522.assignments.a3;

/**
 * The division operation.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class DivisionOperation extends AbstractOperation {
    /**The char division code for division operation.*/
    static final char DIVISION_CODE = '/';
    /**
     * The constructor that passes division code to superclass.
     * */
    public DivisionOperation() {
        super(DIVISION_CODE);
    }
    /**
     * A constructor that perform division for operandA and operandB.
     * @param operandA is one of a operand.
     * @param operandB is another operand.
     * @return an int for division.
     * */
    public int perform(final int operandA, final int operandB) {
        return operandA / operandB;
    }
}
