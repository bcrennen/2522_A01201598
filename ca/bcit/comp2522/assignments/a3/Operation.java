package ca.bcit.comp2522.assignments.a3;

/**
 * An interface called Operation.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public interface Operation {

    char getSymbol();

    int perform(int operandA, int operandB);
}
