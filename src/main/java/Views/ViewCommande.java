package Views;

import Controllers.JeuController;
import Models.Grille;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

public class ViewCommande extends JPanel{
    JToggleButton buttonAsseche;
    JToggleButton buttonDeplace;

    private ButtonGroup buttonGroup;
    JButton boutonSkip;
    public ViewCommande( JeuController controller) {

        super(new GridLayout(1, 3));

        buttonAsseche = new JToggleButton("Asseche");
        this.add(buttonAsseche);

        buttonDeplace = new JToggleButton("Bouger");
        this.add(buttonDeplace);

        boutonSkip = new JButton("Skip");
        this.add(boutonSkip);

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
