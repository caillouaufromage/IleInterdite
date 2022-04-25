package Views;

import Controllers.JeuController;
import Models.Grille;
import utils.Observer;

import javax.swing.*;
import java.awt.*;

public class JeuView implements Observer {
    private final InformationView infoView;
    private JFrame frame;
    private GrilleView grilleView;
    private ViewCommande commande;
    InventoryView inventoryView;
    ExchangeView exchangeView;
    public JeuView(JeuController ctrl, Grille grille, GrilleView grilleView, InformationView infoView, ViewCommande commandeView){

        frame = new JFrame();
        frame.setTitle("L'Île Interdite");
        //frame.setLayout(new BoxLayout(3,1));
        this.grilleView = grilleView;
        this.infoView = infoView;

         inventoryView = new InventoryView(ctrl);
         exchangeView = new ExchangeView(ctrl);
        frame.add(inventoryView, BorderLayout.EAST);
        frame.add(exchangeView, BorderLayout.WEST);
        frame.add(infoView, BorderLayout.PAGE_START);
        frame.add(grilleView, BorderLayout.CENTER);


        ctrl.addObserver(this);
        this.commande = commandeView;
        frame.add(commande,BorderLayout.PAGE_END);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void update() {
        grilleView.update();
    }

    public void delete(){
        frame.dispose();
    }
}
