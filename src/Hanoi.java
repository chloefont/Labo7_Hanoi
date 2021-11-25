import util.Stack;
// source: https://www.sanfoundry.com/java-program-implement-solve-tower-of-hanoi-using-stacks/
public class Hanoi {
    private Stack<Integer> tower1;
    private Stack<Integer> tower2;
    private Stack<Integer> tower3;

    int turn = 0;

    public Hanoi(int numberDisk){
        tower1 = new Stack<>();
        tower2 = new Stack<>();
        tower3 = new Stack<>();

        for(int i = numberDisk; i > 0; i--){
            tower1.push(i);
        }
    }


    public void resolve(){
        System.out.println("-- Turn: " + turn++);
        System.out.println(this);
        transfer(tower1.getSize(), tower1, tower2, tower3);
    }

    private void transfer(int n, Stack<Integer> t1, Stack<Integer> t2, Stack<Integer> t3){

        if (n > 0)
        {
            transfer(n-1, t1, t3, t2);
            int d = t1.pop();
            t3.push(d);
            System.out.println("-- Turn: " + turn++);
            System.out.println(this);
            transfer(n-1, t2, t1, t3);
        }
    }

    @Override
    public String toString() {
        return  "One:   " + tower1 + "\n" +
                "Two:   " + tower2 + "\n" +
                "Three: " + tower3;
    }
}
