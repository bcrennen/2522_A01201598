package ca.bcit.comp2522.assignments.a3;

import java.util.Objects;

/**
 * The parent class for different types of operations.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public abstract class AbstractOperation implements Operation {
    /**Type of operation to be used.*/
    protected char operationType;
    /**
     * The constructor for AbstractOperation.
     *
     * @param operationType to see which operation will be performed.
     * */
    public AbstractOperation(final char operationType) {
        this.operationType = operationType;
    }
    /**
     * The char represents the operation type.
     *
     * @return char
     * */
    public final char getSymbol() {
        return operationType;
    }
}
