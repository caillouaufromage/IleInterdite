package Models;

import utils.Sprite;

import javax.swing.*;
import java.awt.*;

public class Clef extends Item implements Storable {
    ImageIcon imgClef;
    public Clef(int quantity, Element element) {
        super(quantity, element);
        initImg();
    }

    private void initImg(){
        imgClef = Sprite.getIcon(element.name());

    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public Image getImage() {
        return null;
    }

    @Override
    public ImageIcon getIcon() {
        return imgClef;
    }

    public boolean isKey(){
        return true;
    }

    @Override
    public Element getElement() {
        return this.element;
    }
}
