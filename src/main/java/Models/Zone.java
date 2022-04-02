package Models;

import utils.Etat;
import utils.Position;

public class Zone extends Position {
    Etat etat;
    public Zone(int x,int y, Etat etat) {
        super(x,y);
        this.etat = etat;
    }

    public Zone(Position p , Etat etat){
        this(p.x,p.y,etat);
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Model.Zone située en {" +
                 super.toString() +
                "}, \t état= " + etat;
    }
}
