package ca.bcit.comp2522.labs.lab06;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

/**
 * Diver class for sprite and resources.
 *
 * @author brennen
 * @version 2020
 * */
public class Driver {
    /**
     * Main method.
     *
     * @param args for arg
     * */
    public static void main(final String[] args) throws IOException {
        // list the weapons for 2D object.
        ArrayList<String> gundamWeapon = new ArrayList<String>();
        gundamWeapon.add("Gun");
        gundamWeapon.add("beam sword");
        gundamWeapon.add("plasma gun");
        // read the image in file.
        // to read this file, add new image,
        // and save it to your file, and copy path and paste it between ""
        BufferedImage img = ImageIO.read(new File(
                "2522_A01201598/ca/bcit/comp2522/labs/lab06/Stike.png"));
        // create a new sprite for 2D object.
        Sprite s = new Sprite(img, 619, 420, 100, 68.9f, gundamWeapon);
        try {
            System.out.println(s.getPixelData()[114]);
            System.out.println("Pixel Data length: " + s.getPixelData().length);

            FileOutputStream f = new FileOutputStream("sprite.ser");
            ObjectOutput out = new ObjectOutputStream(f);
            out.writeObject(s);
            out.flush();
            out.close();

            FileInputStream f2 = new FileInputStream("sprite.ser");
            ObjectInputStream in = new ObjectInputStream(f2);
            Sprite s2 = (Sprite) in.readObject();
            System.out.println(s2.getPixelData()[4]);
            System.out.println("Pixel Data length: " + s.getPixelData().length);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // create resources for 2D object.
        Resources gamerLevel1 = new Resources(
                "Space Battle", 1,
                s.getXCoordinates(), s.getYCoordinates(), 100, 100, 1);
        // write to file resource.dat.
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new
                    BufferedOutputStream(new FileOutputStream("resource.dat")));

            out.writeUTF(gamerLevel1.getLevelName());
            out.writeInt(gamerLevel1.getLevelNumber());
            out.writeInt(gamerLevel1.getX());
            out.writeInt(gamerLevel1.getY());
            out.writeInt(gamerLevel1.getHealthBar());
            out.writeInt(gamerLevel1.getEnemiesAlive());
            out.writeFloat(s.getGravity());

            for (int i = 0; i < gundamWeapon.size(); i++) {
                out.writeUTF(gundamWeapon.get(i));
            }
            out.write(s.getPixelData().length);
        } catch (Exception e) {
            System.out.println("No Files!" + e);
        } finally {
            out.close();
        }
        // read the file in resource.dat.
        DataInputStream in = null;
        try {
            in = new DataInputStream(new
                    BufferedInputStream(new FileInputStream("resource.dat")));

            System.out.println("\nLevel name: " + in.readUTF());
            System.out.println("\nLevel number: " + in.readInt());
            System.out.println("\nX-coordinate: " + in.readInt());
            System.out.println("\nY-coordinate: " + in.readInt());
            System.out.println("\nHealth remain: " + in.readInt());
            System.out.println("\nEnemies alive: " + in.readInt());
            System.out.println("\nGravity: " + in.readFloat());

            for (int i = 0; i < gundamWeapon.size(); i++) {
                System.out.println("\nWeapons: " + in.readUTF());
            }
        } catch (Exception e) {
            System.out.println("No Files!" + e);
        } finally {
            in.close();
        }
    }
}
