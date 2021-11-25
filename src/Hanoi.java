import utils.stack.Stack;

public class Hanoi {
    private Stack<Integer> tower1;
    private Stack<Integer> tower2;
    private Stack<Integer> tower3;

    private int numberDisk;

    Hanoi(int numberDisk){
        this.numberDisk = numberDisk;
    }

    void resolve(){

    }

    private void towerOfHanoi(int n, char from_rod, char to_rod, char helper_rod) {
        if (n == 1)
        {
            System.out.println("Take disk 1 from rod " +  from_rod + " to rod " + to_rod);
            tower3.push(tower1.pop());
            return;
        }
        towerOfHanoi(n-1, from_rod, helper_rod, to_rod);
        System.out.println("Take disk " + n + " from rod " +  from_rod + " to rod " + to_rod);
        switch (n){
            case tower1.
        }
        towerOfHanoi(n-1, helper_rod, to_rod, from_rod);
    }
    private void tranfert(int n) {
        if (n != 1) {
            tranfert(n - 1);
        }
    }

    @Override
    public String toString() {
        return  "One:   " + tower1 + "\n" +
                "Two:   " + tower2 + "\n" +
                "Three: " + tower3;
    }
}
