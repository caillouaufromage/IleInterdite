package Models;


import utils.Etat;
import utils.Observable;
import utils.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grille  {
    private Zone[][] grille;
    private List<Zone> zonesNormales;
    private List<Zone> zonesSubmergées;
    private List<Zone> zonesInondées;
    private List<Joueur> joueurs;
    private List<Zone> positionsZones;
    Heliport heliport;

    private List<Artefact> artefacts;
    public Grille(List<Joueur> joueurs,List<Artefact> artefacts) {
        grille = new Zone[6][6];
        Etat normal = Etat.Normale;
        this.joueurs = joueurs;
        this.artefacts=artefacts;
        /*grille = new Zone[][]{{new Zone(0,0,normal), new Zone(0,1,normal)},
                              {new Zone(1,0,normal),new Zone(1,1,normal),new Zone(1,2,normal),new Zone(1,3,normal)},
                              {new Zone(2,0,normal),new Zone(2,1,normal),new Zone(2,2,normal),new Zone(2,3,normal),new Zone(2,4,normal), new Zone(2,5,normal)},
                              {new Zone(3,0,normal),new Zone(3,1,normal),new Zone(3,2,normal),new Zone(3,3,normal),new Zone(3,4,normal), new Zone(3,5,normal)},
                              {new Zone(4,0,normal),new Zone(4,1,normal),new Zone(4,2,normal),new Zone(4,3,normal)},
                              {new Zone(5,0,normal), new Zone(5,1,normal)},

};
         */

        Random rand = new Random();
        int i = rand.nextInt(6);
        int j = rand.nextInt(6);
        boolean submerged = (j!= 4 || i !=4) && (j!= 1 || i!=4) && (j!= 4 || i !=1) &&
                (j!= 1 || i!=1) && (i == 0 || i == 1 || i == 4 || i == 5) &&
                (j == 0|| j == 1 || j == 4 || j == 5);
        while (submerged){
            i = rand.nextInt(6);
            j = rand.nextInt(6);
            submerged = (j!= 4 || i !=4) && (j!= 1 || i!=4) && (j!= 4 || i !=1) &&
                    (j!= 1 || i!=1) && (i == 0 || i == 1 || i == 4 || i == 5) &&
                    (j == 0|| j == 1 || j == 4 || j == 5);
        }
        System.out.println(i + "  " + j);
        heliport = new Heliport(i,j,Etat.Normale);
        for ( i = 0; i < 6;i++){
            for (j = 0; j < 6; j++){
                submerged = (j!= 4 || i !=4) && (j!= 1 || i!=4) && (j!= 4 || i !=1) &&
                        (j!= 1 || i!=1) && (i == 0 || i == 1 || i == 4 || i == 5) &&
                        (j == 0|| j == 1 || j == 4 || j == 5);
                if (submerged)
                    grille[i][j] = new Zone(i,j,Etat.Submergée);
                else if ( i == heliport.getX() && j == heliport.getY())
                    grille[i][j] = heliport;
                else {
                    grille[i][j] = new Zone(i, j, normal);
                }
            }
        }

    }

    public List<Zone> getListNonZonesSubmergées(){
        List zonesSubmergées = new ArrayList<Zone>();
        for (int i = 0; i < grille.length;i++){
            for (int j = 0; j < grille.length;j++){
                if (grille[i][j].getEtat() != Etat.Submergée)
                zonesSubmergées.add(grille[i][j]);
            }
        }
        return zonesSubmergées;
    }

    public Zone getZone(int x,int y){
        return grille[x][y];
    }

    public List<Joueur> getPositionJoueurs() {
        return joueurs;
    }

    public List<Artefact> getPositionArtefacts() {
        return artefacts;
    }

    public void setPositionJoueurs(List<Joueur> positionJoueurs) {
        this.joueurs = positionJoueurs;
    }

    public Heliport getHeliport() {
        return heliport;
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

    public boolean isOnBounds(Position p){
        return p.getX()>= 0 && p.getX()<6 && p.getY()>=0 && p.getY()<6;
    }
    public boolean isOnBounds(int x,int y){
        return x>= 0 && x<6 && y>=0 && y<6;
    }


    public Zone[][] getGrille() {
        return grille;
    }
}