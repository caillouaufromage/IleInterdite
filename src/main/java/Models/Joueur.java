package Models;

import utils.Direction;
import utils.Etat;
import utils.Position;

import java.util.ArrayList;
import java.util.List;



public class Joueur extends Position {

    private int numActions;

    private static int count = 0;

    private int id;

    private List<Storable> inventory;

    private String name;
    public Joueur(int x, int y) {
        super(x, y);
        numActions = 3;
        id=++count;
        name = "Joueur"+id;
        inventory = new ArrayList<>();
    }

    public void asseche(Zone zone){
        if (zone == null)
            return;
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
        if (grille.isOnBounds(this.x,this.y+1))
            return grille.getZone(this.x,this.y+1);
        return null;
    }

    public Zone getZoneRight(Grille grille){
        if (grille.isOnBounds(this.x+1,this.y))
            return grille.getZone(this.x+1,this.y);
        return null;
    }

    public Zone getZoneLeft(Grille grille){
        if (grille.isOnBounds(this.x-1,this.y))
            return grille.getZone(this.x-1,this.y);
        return null;
    }

    public Zone getZoneAbove(Grille grille){
        if (grille.isOnBounds(this.x,this.y-1))
            return grille.getZone(this.x,this.y-1);
        return null;
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

    public String getName() {
        return name;
    }

    public void addInventory(Storable stack){
        this.inventory.add(stack);
    }

    public void removeInventory(Storable stack){this.removeInventory(stack);}

    public List<Storable> getInventory() {
        return inventory;
    }

    public boolean hasKeyElement(Element element){
        for (Storable s : inventory){
            if (s.isKey() && s.getElement() == element)
                return true;
        }
        return false;
    }
    public Storable getKeyElement(Element element){
        for (Storable s : inventory){
            if (s.isKey() && s.getElement() == element)
                return s;
        }
        return null;
    }
    public void recupererArtefact(Artefact arte){
        if (arte.getX() == this.x && arte.getY() == this.y && hasKeyElement(arte.getElement())) {
            addInventory(arte);
            decreaseNumActions();
        }
    }

    public boolean isOnZone(Zone zone){
        return this.x == zone.getX() && this.y == zone.getY();
    }

    public boolean hasAllArtefacts(){
        boolean res1 = false;
        boolean res2 = false;
        boolean res3 = false;
        boolean res4 = false;

        for (Storable s : inventory){
            if(!s.isKey() && s.getElement() == Element.Crane)
                res1=true;

        }
        for (Storable s : inventory){
            if(!s.isKey() && s.getElement() == Element.Coffre)
                res2=true;

        }
        for (Storable s : inventory){
            if(!s.isKey() && s.getElement() == Element.Coupe)
                res3=true;

        }
        for (Storable s : inventory){
            if(!s.isKey() && s.getElement() == Element.Cristal)
                res4=true;

        }
        return res1 && res2 && res3 && res4;
    }
}
