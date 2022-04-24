package utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Sprite {
    public static Map<String, ImageIcon> icons = new HashMap<>();
    public static Map<String, Image> images = new HashMap<>();

    public static final int LENGTHSIZEZONE = 100;
    //static String path = "../resources/img/";

    public static void init() {
        icons.put("bouger",loadIcon("boutons/bouger.png",300,60));
        icons.put("assecher",loadIcon("boutons/assecher.png",300,60));

        images.put("submergee", loadImage("zones/submergee.png",100,100));
        images.put("inondee", loadImage("zones/inondee.png",100,100));
        images.put("normale", loadImage("zones/normale.png",100,100));

        images.put("j1", loadImage("joueurs/jBleu.png",40,40));
        images.put("j2", loadImage("joueurs/jJaune.png",40,40));
        images.put("j3", loadImage("joueurs/jRouge.png",40,40));

    }

    static ImageIcon loadIcon(String name, int w, int h) {
        Image image;
        try {
            image = ImageIO.read(Sprite.class.getClassLoader().getResourceAsStream(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ImageIcon icon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        return icon;
    }

    static Image loadImage(String name, int w, int h) {
        Image image;
        try {
            image = ImageIO.read(Sprite.class.getClassLoader().getResourceAsStream(name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ImageIcon icon = new ImageIcon(new ImageIcon(image).getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        return icon.getImage();
    }

}
