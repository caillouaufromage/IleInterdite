package Views;

import Controllers.JeuController;
import utils.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryView extends JPanel implements Observer {
    private JeuController ctrl;
    private List<JLabel> clefsLabels;

    KeyInventory keyInventory;

    ArtefactInventoryView artefactInventoryView;
    public InventoryView(JeuController ctrl){
        this.ctrl = ctrl;
        this.clefsLabels = new ArrayList<>();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension((200 ),200 ));
        this.setAutoscrolls(true);
        keyInventory = new KeyInventory(ctrl.getJoueurActuel().getInventory(),ctrl);
        artefactInventoryView = new ArtefactInventoryView(ctrl.getJoueurActuel().getInventory(),ctrl);
        this.add(keyInventory,BorderLayout.NORTH);
        this.add(artefactInventoryView,BorderLayout.SOUTH);
        ctrl.addObserver(this);
    }

    @Override
    public void update() {
        //repaint();
        artefactInventoryView.update();
        keyInventory.update();
    }
}
