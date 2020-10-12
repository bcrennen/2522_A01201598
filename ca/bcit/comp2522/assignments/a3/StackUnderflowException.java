package ca.bcit.comp2522.assignments.a3;

/**
 * Exception is generated when Stack underflow.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class StackUnderflowException extends Exception {
    /**
     * A constructor for StackUnderflowException.
     * @param str is a message for exception stack underflow.
     * */
    public StackUnderflowException(final String str) {
        super(str);
    }
}
