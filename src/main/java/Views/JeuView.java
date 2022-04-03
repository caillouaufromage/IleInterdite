package Views;

import Models.Grille;

import javax.swing.*;
import java.awt.*;

public class JeuView {
    private JFrame frame;
    private GrilleView grille;
    private ViewCommande commande;

    public JeuView(Grille grilleModel){
        frame = new JFrame();
        frame.setTitle("L'Île Interdite");
        frame.setLayout(new FlowLayout());
        grille = new GrilleView(grilleModel);
        frame.add(grille);
        commande = new ViewCommande();
        frame.add(commande);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
