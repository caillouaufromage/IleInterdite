package Controllers;

import Models.Grille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JeuController implements ActionListener {
    Grille grille;

    public JeuController(Grille grille) {
        this.grille = grille;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
