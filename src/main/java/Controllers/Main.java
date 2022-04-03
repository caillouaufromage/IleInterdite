package Controllers;

import Models.Grille;
import Views.GrilleView;
import Views.JeuView;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Grille grille = new Grille();
            JeuView jeu = new JeuView(grille);
        });
    }
}
