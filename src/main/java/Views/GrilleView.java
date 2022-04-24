package Views;

import Controllers.JeuController;
import Models.Grille;
import Models.Joueur;
import Models.Zone;
import utils.Etat;
import utils.Observer;
import utils.Position;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class GrilleView extends JPanel implements Observer {
    private final int HAUTEUR = 60;
    private final int LONGUEUR = 40;
    private Grille grille;
    private List<Joueur> joueurs;

    private Map.Entry<Integer,Integer> coordinates;

    JeuController ctrl;
    public GrilleView(Grille grille, JeuController ctrl){
        this.grille = grille;
       this.joueurs = grille.getPositionJoueurs();
       this.ctrl = ctrl;
        //System.out.println("test");
        //setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension((LONGUEUR + LONGUEUR /2 ) * 10,(HAUTEUR + HAUTEUR /2 ) * 10));
        setBackground(Color.BLUE);
        this.addKeyListener(ctrl);
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(getWidth() / 4, getHeight()/ 4);
        int c = 0;
        int b = 0;
        for (int i = 0; i < 6;i++) {
            for (int j = 0; j < 6; j++) {
                c = i * (LONGUEUR + LONGUEUR / 2);
                b = j * (HAUTEUR + HAUTEUR / 2);
                paint(g, grille.getZone(i, j), i * (LONGUEUR + LONGUEUR / 2), j * (HAUTEUR + HAUTEUR / 2));
            }
        }
        for (Joueur j : joueurs)
            paint(g,j,j.getX()*(LONGUEUR+LONGUEUR/2),j.getY()*(HAUTEUR + HAUTEUR/2));
    }

    private void paint(Graphics g, Zone zone , int x, int y) {
        /** Sélection d'une couleur. **/
        //System.out.println("test");
        if(zone.getEtat() == Etat.Normale)
            g.setColor(Color.GRAY);
        else if(zone.getEtat() == Etat.Submergée)
            g.setColor(Color.BLUE);
        else if (zone.getEtat() == Etat.Inondée)
            g.setColor(Color.CYAN);
        /** Coloration d'un rectangle. **/
        g.fillRect(x, y,LONGUEUR, HAUTEUR );
    }

    private void paint(Graphics g, Joueur joueur, int x, int y){
        g.setColor(Color.RED);
        g.fillOval(x,y,30,30);
    }

    @Override
    public void update() {
        repaint();
        //System.out.println("REPAINT!!!");
    }


}
