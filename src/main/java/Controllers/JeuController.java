package Controllers;

import Models.*;
import Views.*;
import Views.JeuView;
import utils.*;
import utils.Observable;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JeuController extends Observable implements ActionListener , KeyListener{
    private Grille grilleModel;
    private GrilleView grilleView;

    private ViewCommande commandeView;

    private InformationView infoView;

    private JeuView jeuView;

    private Random r;
    private  int  numTour = 0;

    private Joueur joueurActuel;
    private List<Joueur> joueurs;
    private final int nombreJoueur = 4;
    public JeuController() {

        joueurs = new ArrayList<>();
        joueurs.add(new Joueur(2,3));
        joueurs.add(new Joueur(4,3));
        joueurs.add(new Joueur(4,2));
        joueurActuel = joueurs.get(0);

        this.commandeView = new ViewCommande(this);
        this.infoView = new InformationView(this);
        this.grilleModel = new Grille(joueurs);
        this.grilleView = new GrilleView(grilleModel,this);
        this.jeuView = new JeuView(this,grilleModel, grilleView, infoView, commandeView);
        r = new Random();


    }

    void resetNumActions(){
        for (Joueur j : joueurs)
            j.resetNumActions();
    }
    void innondation(){
        List<Zone> nonZonesSubmergées = grilleModel.getListNonZonesSubmergées();
        for (int i = 0 ; i < 3; i++) {
            nonZonesSubmergées = grilleModel.getListNonZonesSubmergées();
            int upper = nonZonesSubmergées.size();
            if (upper == 0)
                break;
            //System.out.println("Taille : " + upper);
            Zone zonechoisie = nonZonesSubmergées.get(r.nextInt(upper));
            if (zonechoisie.getEtat() == Etat.Inondée)
                zonechoisie.setEtat(Etat.Submergée);
            else if (zonechoisie.getEtat() == Etat.Submergée)
                continue;
            else
                zonechoisie.setEtat(Etat.Inondée);
            //System.out.println("La zone a été innondée : " + zonechoisie);
        }
    }

    void nextJoueur(){
        //System.out.println("Joueur numéro :  " + numTour%joueurs.size());
        joueurActuel = joueurs.get(numTour%joueurs.size());
    }
    void tourSkip(){
        numTour++;
        nextJoueur();
        innondation();
        resetNumActions();


        System.out.println("Tour actuel: " + numTour);
    }

    void moveJoueur(Direction dir){
        try {
            if (grilleModel.isOnBounds(joueurActuel)) {
                switch (dir) {
                    case UP:
                        if (joueurActuel.getZoneAbove(grilleModel).getEtat() != Etat.Submergée)
                            joueurActuel.move(dir);
                        break;
                    case RIGHT:
                        System.out.println(joueurActuel.getZoneRight(grilleModel).getEtat());
                        if (joueurActuel.getZoneRight(grilleModel).getEtat() != Etat.Submergée)
                            joueurActuel.move(dir);
                        break;
                    case LEFT:
                        if (joueurActuel.getZoneLeft(grilleModel).getEtat() != Etat.Submergée)
                            joueurActuel.move(dir);
                        break;
                    case DOWN:
                        if (joueurActuel.getZoneBottom(grilleModel).getEtat() != Etat.Submergée)
                            joueurActuel.move(dir);
                        break;
                }
            }
        }
        catch (Exception e) {
            System.out.println("test");
        }
    }



    private int countCLick = 0;
    boolean moved = false;
    boolean asseched = false;
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getSource() == commandeView.getBoutonSkip()) {
            commandeView.clearButtonGroup();
            moved = false;
            asseched = false;
            tourSkip();

        }
        if (actionEvent.getSource() == commandeView.getButtonAsseche()) {
            if (asseched)
                commandeView.clearButtonGroup();
            moved = commandeView.buttonDeplaceIsSelected();
            asseched = commandeView.buttonAssecheIsSelected();

        }
        if (actionEvent.getSource() == commandeView.getButtonDeplace()) {
            if (moved)
                commandeView.clearButtonGroup();
            moved = commandeView.buttonDeplaceIsSelected();
            asseched = commandeView.buttonAssecheIsSelected();
        }
        grilleView.addNotify();
        notifyObservers();
    }



    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        //System.out.println("Key Realeased");
        System.out.println("Tu peux bouger : + " + moved);
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_Z:
                if (asseched )
                    joueurActuel.asseche(joueurActuel.getZoneAbove(this.grilleModel));
                else if (moved)
                    moveJoueur(Direction.UP);
                break;
            case KeyEvent.VK_S:
                if (asseched )
                    joueurActuel.asseche(joueurActuel.getZoneBottom(this.grilleModel));
                else if (moved)
                    moveJoueur(Direction.DOWN);
                break;
            case KeyEvent.VK_Q:
                if (asseched )
                    joueurActuel.asseche(joueurActuel.getZoneLeft(this.grilleModel));
                else if (moved)
                    moveJoueur(Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                if (asseched )
                    joueurActuel.asseche(joueurActuel.getZoneRight(this.grilleModel));
                else if (moved)
                    moveJoueur(Direction.RIGHT);
                break;
            case KeyEvent.VK_X:
                if (asseched )
                    joueurActuel.asseche(joueurActuel.getZoneOn(this.grilleModel));
                break;


        }
        notifyObservers();
    }

    public Joueur getJoueurActuel() {
        return joueurActuel;
    }
}
