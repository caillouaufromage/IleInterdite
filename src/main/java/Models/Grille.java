package Models;


import utils.Etat;

public class Grille {
    private Zone[][] grille;
    public Grille(){
        //grille = new Model.Zone[6][6];
        Etat normal = Etat.Normale;
        grille = new Zone[][]{{new Zone(0,0,normal), new Zone(0,1,normal)},
                              {new Zone(1,0,normal),new Zone(1,1,normal),new Zone(1,2,normal),new Zone(1,3,normal)},
                              {new Zone(2,0,normal),new Zone(2,1,normal),new Zone(2,2,normal),new Zone(2,3,normal),new Zone(2,4,normal), new Zone(2,5,normal)},
                              {new Zone(3,0,normal),new Zone(3,1,normal),new Zone(3,2,normal),new Zone(3,3,normal),new Zone(3,4,normal), new Zone(3,5,normal)},
                              {new Zone(4,0,normal),new Zone(4,1,normal),new Zone(4,2,normal),new Zone(4,3,normal)},
                              {new Zone(5,0,normal), new Zone(5,1,normal)},

};

    }

    public Zone getZone(int x,int y){
        return grille[x][y];
    }
    @Override
    public String toString() {
        String res = "";
        for (Zone[] zones : grille) {
            for (Zone zone : zones)
                res += zone;
            res+="\n";
        }
        return res;
    }
}