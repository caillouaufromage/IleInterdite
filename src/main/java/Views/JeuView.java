package Views;

import Controllers.JeuController;
import Models.Grille;
import utils.Observable;
import utils.Observer;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;

public class JeuView implements Observer {
    private JFrame frame;
    private GrilleView grille;
    private ViewCommande commande;
    private Grille grilleModel;
    public JeuView(Grille grilleModel){

        this.grilleModel = grilleModel;
        frame = new JFrame();
        frame.setTitle("L'Île Interdite");
        frame.setLayout(new FlowLayout());
        grille = new GrilleView(grilleModel);
        frame.add(grille);


        JeuController controller = new JeuController(grilleModel);
        controller.addObserver(this);

        commande = new ViewCommande(grilleModel,controller);
        frame.add(commande);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void update() {

        grille.update();
        System.out.println(grilleModel);
    }
}
