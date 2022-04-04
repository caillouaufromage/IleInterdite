package Controllers;

import Models.Grille;
import Models.Zone;
import Views.JeuView;
import utils.Etat;
import utils.Observable;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class JeuController extends Observable implements ActionListener {
    Grille grille;
    Random r;
    static int  numTour = 0;
    public JeuController(Grille grille) {
        this.grille = grille;
        r = new Random();
    }

    void innondation(){
        List<Zone> zonesSubmergées = grille.getListNonZonesSubmergées();
        for (int i = 0 ; i < 3; i++) {
            zonesSubmergées = grille.getListNonZonesSubmergées();
            int upper = zonesSubmergées.size();
            if (upper == 0)
                break;
            System.out.println("Taille : " + upper);
            Zone zonechoisie = zonesSubmergées.get(r.nextInt(upper));
            if (zonechoisie.getEtat() == Etat.Inondée)
                zonechoisie.setEtat(Etat.Submergée);
            else if (zonechoisie.getEtat() == Etat.Submergée)
                continue;
            else
                zonechoisie.setEtat(Etat.Inondée);
            System.out.println("La zone a été innondée : " + zonechoisie);
        }
    }
    void tourSkip(){
        numTour++;
        System.out.println("Tour actuel: " + numTour);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        tourSkip();
        innondation();
        notifyObservers();
    }
}
