import Models.Artefact;
import Models.Joueur;
import Models.Zone;
import utils.Etat;
import Models.Grille;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GrilleTest {


    @Test
    public void test_init_grille() {
        List<Joueur> joueurs = new ArrayList<>();
        List<Artefact> artefacts = new ArrayList<>();
        Grille grille = new Grille(joueurs, artefacts);
        Etat normal = Etat.Normale;
        Zone[][] grilleTest = new Zone[][]{{new Zone(0, 0, normal), new Zone(0, 1, normal)},
                {new Zone(1, 0, normal), new Zone(1, 1, normal), new Zone(1, 2, normal), new Zone(1, 3, normal)},
                {new Zone(2, 0, normal), new Zone(2, 1, normal), new Zone(2, 2, normal), new Zone(2, 3, normal), new Zone(2, 4, normal), new Zone(2, 5, normal)},
                {new Zone(3, 0, normal), new Zone(3, 1, normal), new Zone(3, 2, normal), new Zone(3, 3, normal), new Zone(3, 4, normal), new Zone(3, 5, normal)},
                {new Zone(4, 0, normal), new Zone(4, 1, normal), new Zone(4, 2, normal), new Zone(4, 3, normal)},
                {new Zone(5, 0, normal), new Zone(5, 1, normal)}};
        assertEquals(grilleTest, grille.getGrille());
        //Model.Zone[][] test = {{new Model.Zone(0,0,normal), new Model.Zone(0,1,normal)}};
    }
}
