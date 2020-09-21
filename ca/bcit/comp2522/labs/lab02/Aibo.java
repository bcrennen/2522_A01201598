package ca.bcit.comp2522.labs.lab02;

public class Aibo extends Robot implements Speakable {

    private String speak;

    public Aibo() {
        speak = "Woof!";
    }

    public void speak() {
        System.out.println(speak);
    }
}
