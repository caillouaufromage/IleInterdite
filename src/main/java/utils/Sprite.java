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
        icons.put("bouger2",loadIcon("boutons/bouger2.png",300,60));
        icons.put("assecher",loadIcon("boutons/assecher.png",300,60));
        icons.put("assecher2",loadIcon("boutons/assecher2.png",300,60));
        icons.put("skip",loadIcon("boutons/skip.png",300,60));
        icons.put("skip2",loadIcon("boutons/skip2.png",300,60));
        icons.put("recupArtefact",loadIcon("boutons/recupArtefact.png",300,60));
        icons.put("recupArtefact2",loadIcon("boutons/recupArtefact2.png",300,60));

        icons.put("Crane", loadIcon("cartes/carteCrane.png",75,75));
        icons.put("Coffre", loadIcon("cartes/carteCoffre.png",75,75));
        icons.put("Coupe", loadIcon("cartes/carteCoupe.png",75,75));
        icons.put("Cristal", loadIcon("cartes/carteCristal.png",75,75));


        images.put("victory",loadImage("ecrans/Victoire.png", 800, 800));
        images.put("defeate",loadImage("ecrans/Defaite.png", 800, 800));

        images.put("submergee", loadImage("zones/submergee.png",100,100));
        images.put("inondee", loadImage("zones/inondee.png",100,100));
        images.put("normale", loadImage("zones/normale.png",100,100));

        images.put("heliport", loadImage("zones/heliport.png",100,100));
        images.put("heliport2", loadImage("zones/heliport2.png",100,100));


        images.put("j1", loadImage("joueurs/jBleu.png",40,40));
        images.put("j2", loadImage("joueurs/jJaune.png",40,40));
        images.put("j3", loadImage("joueurs/jRouge.png",40,40));

        images.put("Crane", loadImage("artefacts/crane.png",40,40));
        images.put("Coffre", loadImage("artefacts/coffre.png",40,40));
        images.put("Coupe", loadImage("artefacts/coupe.png",40,40));
        images.put("Cristal", loadImage("artefacts/cristal.png",40,40));



    }

    public static Image getImage(String name){
        return images.get(name);
    }
    public static ImageIcon getIcon(String name){
        return icons.get(name);
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
