package Views;

import Controllers.JeuController;
import Models.Joueur;
import utils.Observer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class InformationView extends JPanel implements Observer {
    Joueur joueurActuel;

    JeuController ctrl;

    JLabel idJoueurLabel;

    JLabel numActionsLabel;
    String idJoueurActuel;

    String numActionsJoueurActuel;
    public InformationView(JeuController ctrl){
        this.ctrl = ctrl;
        this.setLayout(new GridLayout(0, 1));

        ctrl.addObserver(this);
        this.joueurActuel = ctrl.getJoueurActuel();


        this.idJoueurActuel = "Joueur actuel : " + joueurActuel.getId();
        idJoueurLabel = new JLabel(idJoueurActuel, SwingConstants.CENTER);
        idJoueurLabel.setFont(new Font("Verdana",1,20));

        this.numActionsJoueurActuel = "Nombre d'actions restantes : " + joueurActuel.getNumActions();
        numActionsLabel  = new JLabel(this.numActionsJoueurActuel, SwingConstants.CENTER);
        numActionsLabel.setFont(new Font("Verdana",1,20));

        this.add(idJoueurLabel);
        this.add(numActionsLabel);
        this.setBorder(new LineBorder(Color.BLACK)); // make it easy to see

    }

    @Override
    public void update() {
        joueurActuel = ctrl.getJoueurActuel();
        idJoueurActuel = "Joueur actuel : " + joueurActuel.getId();
        idJoueurLabel.setText(idJoueurActuel);

        this.numActionsJoueurActuel = "Nombre d'actions restantes : " + joueurActuel.getNumActions();
        this.numActionsLabel.setText(numActionsJoueurActuel);


    }

}
