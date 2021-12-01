package hanoi;

import util.Stack;

// source: https://www.sanfoundry.com/java-program-implement-solve-tower-of-hanoi-using-stacks/

/**
 * Cette classe permet de résoudre le problème des tours d'Hanoi et de suivre la résolution étape par étape.
 */
public class Hanoi {
    final private int NB_TOWERS = 3;
    private final Stack<Integer>[] towers = new Stack[NB_TOWERS];
    private final HanoiDisplayer displayer;
    private boolean isFinished = false;

    private int turn = 0;


    public Hanoi(int numberDisk, HanoiDisplayer displayer) throws IllegalArgumentException {
        for (int i = 0; i < NB_TOWERS; i++)
            towers[i] = new Stack<>();

        if (numberDisk <= 0) {
            throw new IllegalArgumentException("numberDisk should be greater than 0");
        }

        this.displayer = displayer;

        for(int i = numberDisk; i > 0; i--){
            towers[0].push(i);
        }
    }

    public Hanoi(int numberDisk) throws Exception{
        this(numberDisk, new HanoiDisplayer());
    }

    /**
     * Permet d'avoir le contenu de chaque tour(stack) à un instant t.
     * @return un tableau contenant
     */
    public int[][] status() {
        Object[] t1 = towers[0].toArray();
        Object[] t2 = towers[1].toArray();
        Object[] t3 = towers[2].toArray();

        int[][] data = {new int[t1.length], new int[t2.length], new int[t3.length]};
        Object[][] objects = new Object[][]{t1, t2, t3};

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
     * @param n
     * @param t1
     * @param t2
     * @param t3
     */
    private void transfer(int n, Stack<Integer> t1, Stack<Integer> t2, Stack<Integer> t3){

        if (n > 0)
        {
            transfer(n-1, t1, t3, t2);
            int d = t1.pop();
            t3.push(d);
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
