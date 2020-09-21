package ca.bcit.comp2522.labs.lab02;

public abstract class Animal implements Speakable {

    private String speak;

    public Animal() {
        speak = "...";
    }

    public Animal(final String s) {
        speak = s;
    }

    public String getSpeak() {
        return speak;
    }

    public void setSpeak(final String s) {
        this.speak = s;
    }

    public void speak() {
        System.out.println(getSpeak());
    }

}
