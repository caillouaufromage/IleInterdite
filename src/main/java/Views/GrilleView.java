package Views;

import utils.Observer;

import javax.swing.*;

public class GrilleView extends JPanel implements Observer {

    @Override
    public void update() {
        repaint();
    }
}
