package Views;

import Controllers.JeuController;
import Models.*;
import utils.Etat;
import utils.Observer;
import utils.Position;
import utils.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class GrilleView extends JPanel implements Observer {
    private final int HAUTEUR = 60;
    private final int LONGUEUR = 100;
    private Grille grille;
    private List<Joueur> joueurs;

    private List<Artefact> artefacts;


    private Map.Entry<Integer,Integer> coordinates;

    JeuController ctrl;
    public GrilleView(Grille grille, JeuController ctrl){
        this.grille = grille;
       this.joueurs = grille.getPositionJoueurs();
       this.artefacts = grille.getPositionArtefacts();
       this.ctrl = ctrl;
        //System.out.println("test");
        //setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension((LONGUEUR ) * 10,LONGUEUR * 10));
        //setBackground(Color.BLUE);
        this.addKeyListener(ctrl);
    }

    public void addNotify() {
        super.addNotify();
        requestFocus();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(g);
        g.translate(getWidth() / 4, getHeight()/ 4);
        for (int i = 0; i < 6;i++) {
            for (int j = 0; j < 6; j++) {
                paint(g, grille.getZone(i, j), i * (LONGUEUR), j * (LONGUEUR));
            }
        }
        for (Joueur j : joueurs)
            paint(g,j,j.getX()*(LONGUEUR)+LONGUEUR/3,j.getY()*(LONGUEUR)+LONGUEUR/3);
        for (Artefact a : artefacts)
            paint(g,a,a.getX()*(LONGUEUR),a.getY()*(LONGUEUR));
    }

    private void paint(Graphics g, Zone zone , int x, int y) {
        /** Sélection d'une ima. **/
        Image img = zone.getImgZone();
        /** Affichage d'une zone. **/
        g.drawImage(img, x, y, null);
    }

    private void setBackground(Graphics g){
        Image img = Sprite.images.get("submergee");
        Graphics2D g2d = (Graphics2D) g.create();
        for (int y = 0; y < getHeight(); y += img.getHeight(null)) {
            for (int x = 0; x < getWidth(); x += img.getWidth(null)) {
                g2d.drawImage(img, x, y, this);
            }
        }
        //for (int i = 0; i < )
    }
    private void paint(Graphics g, Joueur joueur, int x, int y){
        String name = "j"+joueur.getId();
        Image img = Sprite.images.get(name);
        g.drawImage(img,x,y,null);
    }

    private void paint(Graphics g, Artefact artefact, int x, int y){
        Image img = artefact.getImage();
        g.drawImage(img,x,y,null);
    }

    @Override
    public void update() {
        repaint();
        //System.out.println("REPAINT!!!");
    }


}
