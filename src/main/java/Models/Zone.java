package Models;

import utils.Etat;
import utils.Position;

public class Zone extends Element {
    Etat etat;

    public Zone(int x,int y, Etat etat) {
        super(x,y);
        this.etat = etat;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Zone située en {" +
                 super.toString() +
                "}, état= " + etat;
    }

}
