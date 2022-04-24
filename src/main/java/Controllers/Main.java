package Controllers;

import Models.Grille;
import Views.GrilleView;
import Views.JeuView;
import utils.Sprite;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Sprite.init();
            JeuController controller = new JeuController();

        });
    }
}
