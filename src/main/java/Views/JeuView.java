package Views;

import javax.swing.*;
import java.awt.*;

public class JeuView {
    private JFrame frame;
    private GrilleView grille;

    public JeuView(){
        frame = new JFrame();
        frame.setTitle("L'Île Interdite");
        frame.setLayout(new FlowLayout());
        grille = new GrilleView();
        frame.add(grille);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
