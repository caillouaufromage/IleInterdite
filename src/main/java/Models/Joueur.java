package Models;

import utils.Direction;
import utils.Position;

public class Joueur extends Element {
    public Joueur(int x, int y) {
        super(x, y);
    }

    void seDeplace(Direction dir){
        if(dir == Direction.UP) this.setY(y+1);
        if(dir == Direction.DOWN) this.setY(y-1);
        if(dir == Direction.LEFT) this.setY(x-1);
        if(dir == Direction.RIGHT) this.setY(x+1);
    }

}
