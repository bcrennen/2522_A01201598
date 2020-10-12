package ca.bcit.comp2522.assignments.a3;

/**
 * Data structure of a Stack.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class Stack {
    /**Array of stack values.*/
    private int[] stackValues;
    /**The original number of how big a stack is.*/
    private int count = 0;
    /**
     * The constructor that has a new Stack within given size.
     *
     * @param arraySize the maximum size an int array created.
     * */
    public Stack(final int arraySize) {
        if (arraySize < 1) {
            throw new IllegalArgumentException("Array size "
                    + "cannot be less than 1.");
        }
        stackValues = new int[arraySize];
    }
    /**
     * A method to get the total capacity of a Stack.
     *
     * @return the Stack array size in int.
     * */
    public int capacity() {
        return stackValues.length;
    }
    /**
     * A method to get the number of elements in the Stack.
     *
     * @return the Stack array size in int.
     * */
    public int size() {
        return count;
    }
    /**
     * A method to get the amount of space left in the Stack.
     *
     * @return the unused slots in the Stack array.
     * */
    public int unused() {
        return this.capacity() - this.size();
    }
    /**
     * A method that pushes a value onto the end of a Stack.
     *
     * @param value puts into a Stack array.
     * @throws StackOverflowException when the Stack is full.
     * */
    public void push(final int value) throws StackOverflowException {
        if (this.size() == this.capacity()) {
            throw new StackOverflowException("This Stack is full!");
        }
        stackValues[this.size()] = value;
        count++;
    }
    /**
     * A method that takes out the value at the end of a Stack.
     *
     * @return the removeValue that has been taken out in a Stack array.
     * @throws StackUnderflowException when the Stack is empty.
     * */
    public int pop() throws StackUnderflowException {
        if (this.size() == 0) {
            throw new StackUnderflowException("Cannot call"
                    + "Stack.pop() on an empty stack!");
        }
        int removeValue = stackValues[this.size() - 1];
        stackValues[this.size() - 1] = 0;
        count--;
        return removeValue;
    }
    /**
     * A method that does not remove the value at the end of a Stack.
     *
     * @return the unRemoveValue that is at the end of a Stack array.
     * @throws StackUnderflowException when the Stack is empty.
     * */
    public int peek() throws StackUnderflowException {
        if (this.size() == 0) {
            throw new StackUnderflowException("Cannot call "
                    + "Stack.pop() on an empty stack!");
        }
        int unRemoveValue = stackValues[this.size() - 1];
        return unRemoveValue;
    }
}
