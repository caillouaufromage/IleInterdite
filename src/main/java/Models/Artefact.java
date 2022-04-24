package Models;

import utils.Sprite;

import javax.swing.*;
import java.awt.*;

public class Artefact extends Item  implements Storable {
    private Image img;
    private int x;
    private int y;
    public Artefact(int x,int y, int quantity, Element element) {
        super(quantity, element);
        this.x =x;
        this.y =y;
        initImg();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void initImg(){
        img = Sprite.getImage(element.name());

    }
    @Override
    public Image getImage() {
        return img;
    }

    @Override
    public ImageIcon getIcon() {
        return new ImageIcon(img);
    }

    @Override
    public int getQuantity() {
        return 0;
    }

    public boolean isKey(){
        return false;
    }

    @Override
    public Element getElement() {
        return this.element;
    }

}
