package Models;

import Controllers.JeuController;
import utils.Direction;
import utils.Etat;

import java.util.List;

public class Joueur extends Element {

    private int numActions;

    private static int count = 0;

    private int id;

    private List<Object> inventory;
    public Joueur(int x, int y) {
        super(x, y);
        numActions = 3;
        id=++count;
    }


    public void asseche(Zone zone){
        if (numActions > 0) {
            if (zone.getEtat() == Etat.Inondée) {
                zone.setEtat(Etat.Normale);
                decreaseNumActions();
            }
        }

    }
    public int getNumActions() {
        return numActions;
    }

    public Zone getZoneOn(Grille grille){
        return grille.getZone(this.x,this.y);
    }
    public Zone getZoneBottom(Grille grille){
        return grille.getZone(this.x,this.y+1);
    }

    public Zone getZoneRight(Grille grille){
        return grille.getZone(this.x+1,this.y);
    }

    public Zone getZoneLeft(Grille grille){
        return grille.getZone(this.x-1,this.y);
    }

    public Zone getZoneAbove(Grille grille){
        return grille.getZone(this.x,this.y-1);
    }
    public void setNumActions(int numActioncs) {
        this.numActions = numActions;

    }
    private void decreaseNumActions() {
        this.numActions--;
    }


    public void resetNumActions() {
        this.numActions = 3;
    }

    public void move(Direction dir){
        if (numActions > 0) {
            if (dir == Direction.UP) this.setY(y - 1);
            if (dir == Direction.DOWN) this.setY(y + 1);
            if (dir == Direction.LEFT) this.setX(x - 1);
            if (dir == Direction.RIGHT) this.setX(x + 1);
            this.decreaseNumActions();
        }
    }

    public int getId() {
        return id;
    }
}
