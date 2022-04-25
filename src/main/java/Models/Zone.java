package Models;

import utils.Etat;
import utils.Position;
import utils.Sprite;

import java.awt.*;

public class Zone extends Position {
    protected Etat etat;
    protected Image imgZone;

    public Zone(int x,int y, Etat etat) {
        super(x,y);
        this.etat = etat;
        initImg();
    }

    private void initImg(){
        if (etat == Etat.Submergée)
            imgZone = Sprite.getImage("submergee");
        else if (etat == Etat.Inondée)
            imgZone = Sprite.getImage("inondee");
        else if (etat == Etat.Normale)
            imgZone = Sprite.getImage("normale");

    }

    public Image getImgZone() {
        return imgZone;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
        initImg();
    }

    @Override
    public String toString() {
        return "Zone située en {" +
                 super.toString() +
                "}, état= " + etat;
    }

}
