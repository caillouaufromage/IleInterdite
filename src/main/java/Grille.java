import java.util.Arrays;

public class Grille {
    private Zone[][] grille;
    public Grille(){
        grille = new Zone[6][6];
        for (int i = 1; i < grille.length; i++){
            for (int j = 0; j <= i+1;j++) {
                grille[i-1][j] = new Zone(i-1,j,Etat.Normale);
            }
        }
    }

    public Zone getZone(int x,int y){
        return grille[x][y];
    }
    @Override
    public String toString() {
        return "Grille{" +
                "grille=" + Arrays.toString(grille) +
                '}';
    }
}