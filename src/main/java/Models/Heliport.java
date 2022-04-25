package Models;

import utils.Etat;
import utils.Sprite;

import java.awt.*;

public class Heliport extends  Zone{

    private Image imgHeli;
    public Heliport(int x, int y, Etat etat) {
        super(x, y, etat);
        initImg();
    }

    private void initImg(){
        if (this.etat == Etat.Submergée)
            imgHeli = Sprite.getImage("submergee");
        if (this.etat == Etat.Inondée)
            imgHeli = Sprite.getImage("heliport2");
        if (this.etat == Etat.Normale) {
            imgHeli = Sprite.getImage("heliport");
            System.out.println("test");
        }

    }

    public Image getImgZone() {
        System.out.println("getImg");
        return imgHeli;
    }


    @Override
    public void setEtat(Etat etat) {
        super.setEtat(etat);
        initImg();
    }

    @Override
    public String toString() {
        return "            H         ";
    }
}
