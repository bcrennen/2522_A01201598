package ca.bcit.comp2522.assignments.a3;

/**
 * Exception is generated when Stack overflows.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class StackOverflowException extends Exception {
    /**
     * A constructor for StackOverflowException.
     * @param str is a message for exception stack overflow.
     * */
    public StackOverflowException(final String str) {
        super(str);
    }
}
