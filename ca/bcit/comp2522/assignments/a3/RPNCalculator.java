package ca.bcit.comp2522.assignments.a3;

import java.util.Scanner;

/**
 * Reverse Polish Notation (RPN) calculator.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class RPNCalculator {
    /**The minimum size a stack can have.*/
    static final int MIN_STACK_SIZE = 2;
    /**Instance variable of type stack.*/
    private Stack stack;
    /**
     * A constructor for a new RPN calculator that has a specific size.
     *
     * @param stackSize is the RPN calculator' stack size.
     * @throws IllegalArgumentException when the stack
     * size is below the MIN_STACK_SIZE(2).
     * */
    public RPNCalculator(final int stackSize) throws IllegalArgumentException {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException("The stackSize is too small.");
        }
        this.stack = new Stack(stackSize);
    }
    /**
     * A constructor that process the formula by RPN.
     *
     * @param formula is the number and characters to form a math expression.
     * @throws IllegalArgumentException when there is
     * invalid string in the formula.
     * @throws StackOverflowException when the stack is full.
     * @throws StackUnderflowException when the stack is empty.
     * @throws InvalidOperationTypeException when the operation type is invalid.
     * @return result
     * */
    public int processFormula(final String formula) throws
            IllegalArgumentException, StackOverflowException,
            StackUnderflowException, InvalidOperationTypeException {
        if (formula == null || formula.length() == 0) {
            throw new IllegalArgumentException("Formula does not exist");
        }
        Scanner scan = new Scanner(formula);
        Operation currentOperation;

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                this.push(scan.nextInt());
            }
        }
        return getResult();
    }
    /**
     * A constructor that pushes an operand into a stack.
     *
     * @param operand is a number that will be push into a stack.
     * @throws StackOverflowException when the stack is full.
     * */
    public void push(final int operand) throws StackOverflowException {
        if (stack.unused() == 0) {
            throw new StackOverflowException("No more room left in the stack.");
        }
        stack.push(operand);
    }

    private Operation getOperation(final char symbol)
            throws InvalidOperationTypeException {
        switch (symbol) {
            case AdditionOperation.ADDITION_CODE:
                return new AdditionOperation();
            case SubtractionOperation.SUBTRACTION_CODE:
                return new SubtractionOperation();
            case MultiplicationOperation.MULTIPLICATION_CODE:
                return new MultiplicationOperation();
            case DivisionOperation.DIVISION_CODE:
                return new DivisionOperation();
            default:
                throw new InvalidOperationTypeException("No symbol exist.");
        }
    }
    /**
     * This to retrieve the current value in the stack.
     *
     * @return the result retrieved.
     * @throws StackUnderflowException when the stack is empty.
     * */
    public int getResult() throws StackUnderflowException {
        if (stack.size() == 0) {
            throw new StackUnderflowException("No operands.");
        }
        return stack.peek();
    }

    public void perform(final Operation operation)
            throws IllegalArgumentException, StackUnderflowException,
            StackOverflowException, InvalidOperationTypeException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null.");
        }
        int operandB = stack.pop();
        int operandA = stack.pop();

        int result = operation.perform(operandA, operandB);
        stack.push(result);
    }
    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     *
     * Example usage: RPNCalculator 10 "1 2 +"
     *
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     *             to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {
        // Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }
        // Initializes stack and RPNCalculator
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);

        try {
            System.out.println("[" + argv[1] + "] ="
                    + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println("formula can only contain integers, +, -, *, /, %, and @");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands in the formula, increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }
}
