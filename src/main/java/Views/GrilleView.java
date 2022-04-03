package Views;

import Models.Grille;
import Models.Zone;
import utils.Etat;
import utils.Observer;

import javax.swing.*;
import java.awt.*;

public class GrilleView extends JPanel implements Observer {
    int HAUTEUR = 60;
    int LONGUEUR = 40;
    private Grille grille;
    public GrilleView(Grille grille){
        this.grille = grille;

        //System.out.println("test");
        //setBackground(Color.BLUE);
        this.setPreferredSize(new Dimension((LONGUEUR + LONGUEUR /2 ) * 10,(HAUTEUR + HAUTEUR /2 ) * 10));
        setBackground(Color.BLUE);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 6;i++)
            for (int j = 0; j < 6; j++)
                paint(g, grille.getZone(i,j) , i*(LONGUEUR+LONGUEUR/2), j*(HAUTEUR + LONGUEUR/2));
    }

    private void paint(Graphics g, Zone zone , int x, int y) {
        /** Sélection d'une couleur. */
        //System.out.println("test");
        if(zone.getEtat() == Etat.Normale)
            g.setColor(Color.GRAY);
        else if(zone.getEtat() == Etat.Submergée)
            g.setColor(Color.BLUE);
        /** Coloration d'un rectangle. */
        g.fillRect(x, y,LONGUEUR, HAUTEUR );

    }

    @Override
    public void update() {
        repaint();
    }
}
