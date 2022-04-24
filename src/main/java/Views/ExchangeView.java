package Views;

import Controllers.JeuController;
import Models.Joueur;
import Models.Storable;
import utils.Observer;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ExchangeView extends JPanel implements Observer {

    JeuController ctrl;
    JComboBox<String> joueursSelect;
    JComboBox<String> cb;
    public ExchangeView(JeuController ctrl){
        this.ctrl = ctrl;
        ctrl.addObserver(this);
        List<String> joueursName = new ArrayList<>();
        for (Joueur j : ctrl.getJoueurs())
            joueursName.add(j.getName());
        String[] choices = joueursName.toArray(new String[joueursName.size()]);

        joueursSelect = new JComboBox<>(choices);

        joueursSelect.setVisible(true);
        this.add(joueursSelect);


        List<String> clefsName = new ArrayList<>();
        for (Storable s  : ctrl.getJoueurActuel().getInventory())
            if (s.isKey())
                clefsName.add(s.getElement().getName());
        String[] choicesClefs = clefsName.toArray(new String[clefsName.size()]);
        cb = new JComboBox<>(choicesClefs);
        cb.setVisible(true);
        this.add(cb);
    }

    @Override
    public void update() {
        /*List<String> clefsName = new ArrayList<>();
        System.out.println("UPDATE EXHCNAGE");
        for (Stackable s  : ctrl.getJoueurActuel().getInventory())
            if (s.isKey())
                //clefsName.add(s.getElement().getName());
        String[] choicesClefs = clefsName.toArray(new String[clefsName.size()]);
        for (String s : choicesClefs)
            System.out.println(s);
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>( choicesClefs );
        cb.setModel(model);*/
    }
}



