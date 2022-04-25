package Views;

import utils.Sprite;

import javax.swing.*;
import java.awt.*;

public class EndGame {

    JFrame frame;

    public EndGame(boolean victory){
        frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(800, 800));
        frame.setPreferredSize(new Dimension(800,800));
        System.out.println(Sprite.getImage("defeate"));
        if (victory)
            frame.setContentPane(new JLabel(new ImageIcon(Sprite.getImage("victory"))));
        else
            frame.setContentPane(new JLabel(new ImageIcon(Sprite.getImage("defeate"))));
    }
}
