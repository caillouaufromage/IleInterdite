package Views;

import utils.Observer;
import java.awt.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class ZoneView extends JPanel implements Observer {
    int x,y;
    int size;

    public ZoneView(){

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        //g.fillRect(x, y,x+1);
    }

    @Override
    public void update() {
        repaint();
    }
}
