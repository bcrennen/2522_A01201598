package ca.bcit.comp2522.labs.lab02.test;

import ca.bcit.comp2522.labs.lab02.Aibo;
import ca.bcit.comp2522.labs.lab02.Cat;
import ca.bcit.comp2522.labs.lab02.Dog;
import ca.bcit.comp2522.labs.lab02.IncessantSpeakable;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test
    public void testIncessantSpeakableOfCat() {

        Cat c = new Cat();
        assertEquals(false, (c instanceof IncessantSpeakable));
    }

    @Test
    public void testIncessantSpeakableOfDog() {

        Dog d = new Dog();
        assertEquals(false, (d instanceof IncessantSpeakable));
    }

    @Test
    public void testIncessantSpeakableOfAibot() {

        Aibo a = new Aibo();
        assertEquals(false, (a instanceof IncessantSpeakable));
    }

    @Test
    public void testIncessantOfDogSpeaksWoofWoof() {

        Dog D = new Dog();
        assertEquals("Woof woof!", (D.getSpeak()));
    }
}
