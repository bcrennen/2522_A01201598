package ca.bcit.comp2522.assignments.a3;
/**
 * Exception is generated when Stack overflows.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class InvalidOperationTypeException extends Exception {
    /**
     * A constructor for InvalidOperationTypeException.
     * @param str is a message when there is a invalid operation type.
     */
    public InvalidOperationTypeException(final String str) {
        super(str);
    }
}
