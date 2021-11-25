import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(5);
        stack.push(4);
        Object[] tab = stack.toArray();
        Iterator i = stack.getIterator();

        for (int j = 0; j < 4; j++) {
            System.out.println(i.next());
        }
    }
}
