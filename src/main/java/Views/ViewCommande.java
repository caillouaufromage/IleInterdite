package Views;

import Controllers.JeuController;
import utils.ImageLoader;
import utils.Sprite;

import javax.imageio.ImageIO;
import javax.swing.*;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ViewCommande extends JPanel{
    JToggleButton buttonAsseche;
    JToggleButton buttonDeplace;

    private ButtonGroup buttonGroup;
    JButton boutonSkip;
    public ViewCommande( JeuController controller) {

        super(new GridLayout(1, 3));


        buttonAsseche = new JToggleButton();
        this.add(buttonAsseche);

        buttonDeplace = new JToggleButton();

        this.add(buttonDeplace);

        boutonSkip = new JButton("Skip");
        this.add(boutonSkip);


        buttonDeplace.setIcon(Sprite.icons.get("bouger"));
        buttonDeplace.setBorderPainted(false);
        buttonDeplace.setFocusPainted(false);
        buttonDeplace.setContentAreaFilled(false);

        buttonAsseche.setIcon(Sprite.icons.get("assecher"));
        buttonAsseche.setBorderPainted(false);
        buttonAsseche.setFocusPainted(false);
        buttonAsseche.setContentAreaFilled(false);

        buttonGroup = new ButtonGroup();

        buttonGroup.add(boutonSkip);
        buttonGroup.add(buttonDeplace);
        buttonGroup.add(buttonAsseche);

        boutonSkip.addActionListener(controller);
        buttonDeplace.addActionListener(controller);
        buttonAsseche.addActionListener(controller);



    }

    public JButton getBoutonSkip() {
        return boutonSkip;
    }

    public JToggleButton getButtonAsseche() {
        return buttonAsseche;
    }

    public JToggleButton getButtonDeplace() {
        return buttonDeplace;
    }

    public boolean buttonSkipIsSelected() {
        return boutonSkip.isSelected();
    }

    public boolean buttonDeplaceIsSelected() {
        return buttonDeplace.isSelected();
    }

    public boolean buttonAssecheIsSelected() {
        return buttonAsseche.isSelected();
    }


    public void clearButtonGroup() {
        buttonGroup.clearSelection();
    }

}
