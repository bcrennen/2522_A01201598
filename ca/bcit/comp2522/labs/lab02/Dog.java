package ca.bcit.comp2522.labs.lab02;

public class Dog extends Animal {

    public Dog() {
        //speak = "Meow!";
        super("Woof woof!");
    }

    public void speak() {
        System.out.println(getSpeak());
    }
}
