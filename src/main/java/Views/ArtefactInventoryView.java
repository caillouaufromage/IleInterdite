package Views;

import Controllers.JeuController;
import Models.Storable;
import utils.Observer;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ArtefactInventoryView extends JPanel implements Observer {
    private List<JLabel> clefsLabels;
    JeuController ctrl;

    List<Storable> inventory;
    public ArtefactInventoryView(List<Storable> inventory, JeuController ctrl) {
        this.ctrl = ctrl;
        ctrl.addObserver(this);
        this.inventory = inventory;
        this.clefsLabels = new ArrayList<>();
        this.setLayout(new GridLayout(0, 2));
        this.setPreferredSize(new Dimension((200), 200));
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 0;
        int y = 0;
        for (int i = 0; i < inventory.size(); i++) {
            Storable s = inventory.get(i);
            if (i != 0 && i % 2 == 0) {
                x = 0;
                y++;
            }
            if(!s.isKey())
                g.drawImage(s.getIcon().getImage(), (x) * 100, y * 100, null);
            x++;
        }
    }

    @Override
    public void update() {
        this.inventory = ctrl.getJoueurActuel().getInventory();
        repaint();
    }
}
