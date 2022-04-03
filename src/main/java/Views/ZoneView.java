package Views;

import utils.Observer;
import java.awt.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class ZoneView  implements Observer {
    int x,y;
    int HAUTEUR = 40;
    int LARGEUR = 20;

    public ZoneView(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(x, y,LARGEUR, HAUTEUR);
    }

    @Override
    public void update() {

    }
}
