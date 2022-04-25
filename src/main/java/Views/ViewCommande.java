package Views;

import Controllers.JeuController;
import utils.Sprite;

import javax.swing.*;


import java.awt.*;


public class ViewCommande extends JPanel{
    JToggleButton buttonAsseche;
    JToggleButton buttonDeplace;

    JToggleButton buttonRecup;

    private ButtonGroup buttonGroup;
    JButton boutonSkip;
    public ViewCommande( JeuController controller) {

        super(new GridLayout(1, 3));


        buttonAsseche = new JToggleButton();
        this.add(buttonAsseche);

        buttonDeplace = new JToggleButton();

        buttonRecup = new JToggleButton();
        this.add(buttonRecup);

        this.add(buttonDeplace);

        boutonSkip = new JButton();
        this.add(boutonSkip);




        buttonDeplace.setIcon(Sprite.icons.get("bouger"));
        buttonDeplace.setSelectedIcon(Sprite.icons.get("bouger2"));
        buttonDeplace.setBorderPainted(false);
        buttonDeplace.setFocusPainted(false);
        buttonDeplace.setContentAreaFilled(false);

        buttonAsseche.setIcon(Sprite.icons.get("assecher"));
        buttonAsseche.setSelectedIcon(Sprite.icons.get("assecher2"));
        buttonAsseche.setBorderPainted(false);
        buttonAsseche.setFocusPainted(false);
        buttonAsseche.setContentAreaFilled(false);

        boutonSkip.setIcon(Sprite.icons.get("skip"));
        boutonSkip.setPressedIcon(Sprite.icons.get("skip2"));
        boutonSkip.setBorderPainted(false);
        boutonSkip.setFocusPainted(false);
        boutonSkip.setContentAreaFilled(false);


        buttonRecup.setIcon(Sprite.getIcon("recupArtefact"));
        buttonRecup.setSelectedIcon(Sprite.getIcon("recupArtefact2"));
        buttonRecup.setBorderPainted(false);
        buttonRecup.setFocusPainted(false);
        buttonRecup.setContentAreaFilled(false);


        buttonGroup = new ButtonGroup();

        buttonGroup.add(buttonRecup);
        buttonGroup.add(boutonSkip);
        buttonGroup.add(buttonDeplace);
        buttonGroup.add(buttonAsseche);

        boutonSkip.addActionListener(controller);
        buttonDeplace.addActionListener(controller);
        buttonAsseche.addActionListener(controller);
        buttonRecup.addActionListener(controller);


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

    public JToggleButton getButtonRecup() {
        return buttonRecup;
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
    public boolean buttonRecupIsSelected() {
        return buttonRecup.isSelected();
    }


    public void clearButtonGroup() {
        buttonGroup.clearSelection();
    }

}
