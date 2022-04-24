package Views;

import Controllers.JeuController;
import Models.Joueur;
import utils.Observer;
import utils.Sprite;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class InformationView extends JPanel implements Observer {
    Joueur joueurActuel;

    JeuController ctrl;

    JLabel idJoueurLabel;

    JLabel numActionsLabel;


    JLabel iconJActuel;

    String idJoueurActuel;

    String numActionsJoueurActuel;
    public InformationView(JeuController ctrl){
        this.ctrl = ctrl;
        this.setLayout(new GridLayout(2, 1));

        ctrl.addObserver(this);
        this.joueurActuel = ctrl.getJoueurActuel();


        //this.idJoueurActuel = "Joueur actuel : " + joueurActuel.getId();
        //idJoueurLabel = new JLabel(idJoueurActuel, SwingConstants.CENTER);
        //idJoueurLabel.setFont(new Font("Verdana",1,20));

        ImageIcon icon = new ImageIcon(Sprite.images.get("j"+ joueurActuel.getId()));
        iconJActuel = new JLabel( icon, SwingConstants.CENTER);

        this.numActionsJoueurActuel = "Nombre d'actions restantes : " + joueurActuel.getNumActions();
        numActionsLabel  = new JLabel(this.numActionsJoueurActuel, SwingConstants.CENTER);
        numActionsLabel.setFont(new Font("Verdana",1,20));

        this.add(iconJActuel);
        this.add(numActionsLabel);
      
        this.setBorder(new LineBorder(Color.BLACK)); // make it easy to see

    }

    @Override
    public void update() {
        joueurActuel = ctrl.getJoueurActuel();

       // idJoueurActuel = "Joueur actuel : " + joueurActuel.getId();
       // idJoueurLabel.setText(idJoueurActuel
        // );
        ImageIcon icon = new ImageIcon(Sprite.images.get("j"+ joueurActuel.getId()));
        iconJActuel.setIcon(icon);

        this.numActionsJoueurActuel = "Nombre d'actions restantes : " + joueurActuel.getNumActions();
        this.numActionsLabel.setText(numActionsJoueurActuel);


    }

}
