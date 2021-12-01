package hanoi;

/**
 * Cette classe peut être redéfinie pour modifier le comportement à chaque étape de la résolution de la tour d'Hanoi.
 */
public class HanoiDisplayer {

    /**
     * Affiche les étape de la résolution du Hanoi.
     * @param h Hanoi dont la résolution doit être affichée.
     */
    public void display(Hanoi h){
        System.out.println(h.display());
    }

}
