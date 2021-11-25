package hanoi;

import util.Stack;

import java.util.Arrays;

// source: https://www.sanfoundry.com/java-program-implement-solve-tower-of-hanoi-using-stacks/
public class Hanoi {
    private final Stack<Integer> tower1;
    private final Stack<Integer> tower2;
    private final Stack<Integer> tower3;
    private final HanoiDisplayer displayer;
    private boolean isFinished = false;

    private int turn = 0;

    public Hanoi(int numberDisk, HanoiDisplayer displayer){
        tower1 = new Stack<>();
        tower2 = new Stack<>();
        tower3 = new Stack<>();
        this.displayer = displayer;

        for(int i = numberDisk; i > 0; i--){
            tower1.push(i);
        }
    }

    public Hanoi(int numberDisk){
        this(numberDisk, new HanoiDisplayer());
    }

    public int[][] status() {
        Object[] t1 = tower1.toArray();
        Object[] t2 = tower2.toArray();
        Object[] t3 = tower3.toArray();

        int[][] data = {new int[t1.length], new int[t2.length], new int[t3.length]};
        Object[][] objects = new Object[][]{t1, t2, t3};

        for(int i = 0; i < objects.length; i++){
            for (int j = 0; j < objects[i].length; j++){
                data[i][j] =  (int)objects[i][j];
            }
        }

        return data;
    }


    public void solve(){
        displayer.display(this);
        transfer(tower1.getSize(), tower1, tower2, tower3);
        isFinished = true;
    }

    private void transfer(int n, Stack<Integer> t1, Stack<Integer> t2, Stack<Integer> t3){

        if (n > 0)
        {
            transfer(n-1, t1, t3, t2);
            int d = t1.pop();
            t3.push(d);
            displayer.display(this);
            transfer(n-1, t2, t1, t3);
        }
    }

    public boolean finished(){
        return isFinished;
    }

    public String display(){
        return "-- Turn: " + turn++ + "\n" + this;
    }

    public int turn() {
        return turn;
    }

    @Override
    public String toString() {
        return  "One:   " + tower1 + "\n" +
                "Two:   " + tower2 + "\n" +
                "Three: " + tower3;
    }
}
