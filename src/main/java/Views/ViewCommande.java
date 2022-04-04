package Views;

import Controllers.JeuController;
import Models.Grille;

import javax.swing.*;

public class ViewCommande extends JPanel{
    public ViewCommande(Grille grille, JeuController controller) {
        JButton boutonSkip = new JButton("Skip");
        this.add(boutonSkip);

        boutonSkip.addActionListener(controller);

    }
}
