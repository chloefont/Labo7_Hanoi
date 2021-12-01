package hanoi;

import util.Stack;

/**
 * Cette classe permet de résoudre le problème des tours d'Hanoi et de suivre la résolution étape par étape.
 */
public class Hanoi {
    static private final int NB_TOWERS = 3;
    private final Stack<Integer>[] towers = new Stack[NB_TOWERS];
    private final HanoiDisplayer displayer;
    private boolean isFinished = false;

    private int turn = 0;

    /**
     * Constructeur de la classe Hanoi.
     * @param numberDisk nombre de disques à placer sur la première tour.
     * @param displayer permettant de gérer l'affichage (si null, n'affiche rien).
     * @throws IllegalArgumentException si numberDisk <= 0
     */
    public Hanoi(int numberDisk, HanoiDisplayer displayer) throws IllegalArgumentException {
        if (numberDisk <= 0) {
            throw new IllegalArgumentException("NumberDisk should be greater than 0");
        }

        for (int i = 0; i < NB_TOWERS; i++)
            towers[i] = new Stack<>();

        this.displayer = displayer;

        for(int i = numberDisk; i > 0; i--){
            towers[0].push(i);
        }
    }

    /**
     * Constructeur de la classe Hanoi.
     * @param numberDisk nombre de disques à placer sur la première tour.
     * @throws IllegalArgumentException si numberDisk <= 0
     */
    public Hanoi(int numberDisk) throws IllegalArgumentException{
        this(numberDisk, new HanoiDisplayer());
    }

    /**
     * Permet d'avoir le contenu de chaque tour(stack) à un instant t.
     * @return un tableau contenant le contenu des tours.
     */
    public int[][] status() {
        Object[][] objects = new Object[NB_TOWERS][];
        int[][] data = new int[NB_TOWERS][];

        for (int i = 0; i < NB_TOWERS; i++) {
            objects[i] = towers[i].toArray();
            data[i] = new int[towers[i].getSize()];
        }

        for(int i = 0; i < objects.length; i++){
            for (int j = 0; j < objects[i].length; j++){
                data[i][j] =  (int)objects[i][j];
            }
        }

        return data;
    }

    /**
     * Permet de lancer la résolution. Cette méthode appel à chaque étape HanoiDisplayer.display.
     */
    public void solve(){
        if (displayer != null)
            displayer.display(this);
        transfer(towers[0].getSize(), towers[0], towers[1], towers[2]);
        isFinished = true;
    }

    /**
     * L'algorithme utilisé pour la résolution de Hanoi.
     * @param n nombre de disques du Hanoi.
     * @param t1 tour 1.
     * @param t2 tour 2.
     * @param t3 tour 3.
     */
    private void transfer(int n, Stack<Integer> t1, Stack<Integer> t2, Stack<Integer> t3){
        if (n > 0) {
            transfer(n-1, t1, t3, t2);
            int disque = t1.pop();
            t3.push(disque);
            if (displayer != null)
                displayer.display(this);
            transfer(n-1, t2, t1, t3);
        }
    }

    public boolean finished(){
        return isFinished;
    }

    /**
     * Permet de récupérer le tour actuel au format String.
     * @return le tour.
     */
    public String display(){
        return "-- Turn: " + turn++ + "\n" + this;
    }

    /**
     * Getter du nombre de tour.
     * @return le nombre de tour.
     */
    public int turn() {
        return turn;
    }

    @Override
    public String toString() {
        return  "One:   " + towers[0] + "\n" +
                "Two:   " + towers[1] + "\n" +
                "Three: " + towers[2];
    }
}
